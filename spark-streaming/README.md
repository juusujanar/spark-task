# Spark Streaming

Oli soov järgi proovida striimingu osa, et näha ja proovida selle võimalusi ning rakendusi.
Tulemuseks sai valitud Twitterist sõnumite kogumise filtri järgi ning vaadata, millised hashtagid on nendes kõige levinumad.
Kuna seda ülesannet on päris palju tehtud, siis võib sarnast koodi palju olla. 

Kasutatud Apache Spark 1.6.3, Scala 2.11.12, sbt 1.1.0, Java 1.8.0_152. Ei saanud uuemat Sparki versiooni kasutada, sest Twitteri
striimingu moodul ei toeta uuemat.

### Kasutamine
Iga skript tahab vähemalt 5 parameetrit: consumerKey, consumerSecret, accessToken, accessTokenSecret ning fitrid.
Filtrid võivad olla lihtsalt sõned, mida otsida sõnumite sisust.

API ühendusvõtmed saab, kui luua enda Twitteri konto alt uus applikatsioon - https://apps.twitter.com/

### Näide
##### Sisend
```
<consumerKey> <consumerSecret> <accessToken> <accessTokenSecret> intel spectre meltdown
```

##### Väljund
Hoiatused on välja jäetud tulemustest
```
60 sekundi levinumad hashtagid (20 kokku):
#Meltdown? (3 sõnumit)
#Spectre (3 sõnumit)
#Meltdown (2 sõnumit)
#NoKo (1 sõnumit)
#… (1 sõnumit)
#Huma (1 sõnumit)
#ChappaquaFire (1 sõnumit)
#nhpolitics (1 sõnumit)
#EMP (1 sõnumit)
#Bannon (1 sõnumit)

10 sekundi levinumad hashtagid (19 kokku):
#Meltdown? (3 sõnumit)
#Spectre (3 sõnumit)
#Meltdown (2 sõnumit)
#NoKo (1 sõnumit)
#… (1 sõnumit)
#Huma (1 sõnumit)
#ChappaquaFire (1 sõnumit)
#nhpolitics (1 sõnumit)
#EMP (1 sõnumit)
#Bannon (1 sõnumit)

60 sekundi levinumad hashtagid (29 kokku):
#Meltdown (4 sõnumit)
#Spectre (4 sõnumit)
#Meltdown? (3 sõnumit)
#infosec (2 sõnumit)
#electronics (2 sõnumit)
#NoKo (1 sõnumit)
#… (1 sõnumit)
#Huma (1 sõnumit)
#intel (1 sõnumit)
#ChappaquaFire (1 sõnumit)

10 sekundi levinumad hashtagid (11 kokku):
#infosec (2 sõnumit)
#Meltdown (2 sõnumit)
#electronics (2 sõnumit)
#intel (1 sõnumit)
#Spe… (1 sõnumit)
#vulnérabilités (1 sõnumit)
#exploit (1 sõnumit)
#CyberSecurity (1 sõnumit)
#meltdo… (1 sõnumit)
#cybersecurity (1 sõnumit)

60 sekundi levinumad hashtagid (38 kokku):
#Meltdown (7 sõnumit)
#Spectre (6 sõnumit)
#Meltdown? (5 sõnumit)
#infosec (3 sõnumit)
#AMJoy (3 sõnumit)
#wwwhatsnew (2 sõnumit)
#intel (2 sõnumit)
#vulnérabilités (2 sõnumit)
#electronics (2 sõnumit)
#meltdo… (2 sõnumit)

10 sekundi levinumad hashtagid (12 kokku):
#wwwhatsnew (2 sõnumit)
#Meltdown? (2 sõnumit)
#AMJoy (2 sõnumit)
#followers. (1 sõnumit)
#intel (1 sõnumit)
#infosec (1 sõnumit)
#Gameup24… (1 sõnumit)
#meltdo… (1 sõnumit)
#Hunted (1 sõnumit)
#cybersecurity (1 sõnumit)
```