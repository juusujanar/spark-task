package eu.juusujanar.scala

import org.apache.spark.streaming.{ Seconds, StreamingContext }
import org.apache.spark.streaming.twitter._
import org.apache.spark.{ SparkContext, SparkConf }

object TwitterPopularHashTags {

  def main(args: Array[String]) {

    val conf = new SparkConf().setMaster("local[5]").setAppName("TwitterPopularHashtags")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")

    val Array(consumerKey, consumerSecret, accessToken, accessTokenSecret) = args.take(4)
    val filters = args.takeRight(args.length - 4)

    System.setProperty("twitter4j.oauth.consumerKey", consumerKey)
    System.setProperty("twitter4j.oauth.consumerSecret", consumerSecret)
    System.setProperty("twitter4j.oauth.accessToken", accessToken)
    System.setProperty("twitter4j.oauth.accessTokenSecret", accessTokenSecret)

    val ssc = new StreamingContext(sc, Seconds(5))
    val stream = TwitterUtils.createStream(ssc, None, filters)

    val hashTags = stream.flatMap(status => status.getText.split(" ").filter(_.startsWith("#")))

    val topCounts60 = hashTags.map((_, 1)).reduceByKeyAndWindow(_ + _, Seconds(60))
      .map { case (topic, count) => (count, topic) }
      .transform(_.sortByKey(ascending = false))

    val topCounts10 = hashTags.map((_, 1)).reduceByKeyAndWindow(_ + _, Seconds(10))
      .map { case (topic, count) => (count, topic) }
      .transform(_.sortByKey(ascending = false))

    topCounts60.foreachRDD(rdd => {
      println("\n60 sekundi levinumad hashtagid (%s kokku):".format(rdd.count()))
      rdd.take(10).foreach { case (count, tag) => println("%s (%s sõnumit)".format(tag, count)) }
    })
    topCounts10.foreachRDD(rdd => {
      println("\n10 sekundi levinumad hashtagid (%s kokku):".format(rdd.count()))
      rdd.take(10).foreach { case (count, tag) => println("%s (%s sõnumit)".format(tag, count)) }
    })

    ssc.start()
    ssc.awaitTermination()
  }
}
