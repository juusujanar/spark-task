# Programmeerimiskeeled - Apache Spark
Põhiline eesmärk oli proovida Apache Spark'i striimingu osa, kuna olen varasemalt ühes TÜ aines kasutanud Sparki (kuigi tookord kasutasime Javat).

Kasutatud Apache Spark 1.6.3, Scala 2.11.12, sbt 1.1.0, Java 1.8.0_152

1. TwitterPopularHashtags
2. 


### Kuidas kasutada?

Iga skript tahab vähemalt 5 parameetrit: consumerKey, consumerSecret, accessToken, accessTokenSecret ning filtrid.
Filtrid võivad olla lihtsalt sõned, mida otsida. API ühendusvõtmed saab, kui luua enda Twitteri konto alt uus applikatsioon - https://apps.twitter.com/ 

### Kasutatud allikad / Used sources:
* https://github.com/apache/bahir/blob/master/streaming-twitter/examples/src/main/scala/org/apache/spark/examples/streaming/twitter/TwitterPopularTags.scala
* https://mapr.com/blog/spark-streaming-and-twitter-sentiment-analysis/