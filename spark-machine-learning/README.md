# Spark Machine Learning

Kuna mul on suur huvi masinõppe ning tehisnärvivõrkude vastu, siis proovisin ka masinõppe mudelit ehitada Sparkis.
Leidsin internetis andmeteks ühe Taiwani panga andmed, kus on krediitkaardi kasutuse andmed ning kas need suletakse või ei.
Kasutasin RandomForestClassifier'i mudeli treenimiseks. Enamus aega kulus siiski algandmete kohendamiseks sobivale kujule.

Kasutatud Apache Spark 2.2.1, Scala 2.11.12, sbt 1.1.0, Java 1.8.0_152.

### Saadud tulemus:
```
Test Error = 0.17990601924367866
```

### Andmekogumik:

**Allikas:** https://archive.ics.uci.edu/ml/datasets/default+of+credit+card+clients

**Ülesehitus:**
X1: Amount of the given credit (NT dollar): it includes both the individual consumer credit and his/her family (supplementary) credit. 

X2: Gender (1 = male; 2 = female). 

X3: Education (1 = graduate school; 2 = university; 3 = high school; 4 = others). 

X4: Marital status (1 = married; 2 = single; 3 = others). 

X5: Age (year). 

X6 - X11: History of past payment. We tracked the past monthly payment records (from April to September, 2005) as follows: X6 = the repayment status in September, 2005; X7 = the repayment status in August, 2005; . . .;X11 = the repayment status in April, 2005. The measurement scale for the repayment status is: -1 = pay duly; 1 = payment delay for one month; 2 = payment delay for two months; . . .; 8 = payment delay for eight months; 9 = payment delay for nine months and above. 

X12-X17: Amount of bill statement (NT dollar). X12 = amount of bill statement in September, 2005; X13 = amount of bill statement in August, 2005; . . .; X17 = amount of bill statement in April, 2005. 

X18-X23: Amount of previous payment (NT dollar). X18 = amount paid in September, 2005; X19 = amount paid in August, 2005; . . .;X23 = amount paid in April, 2005.

Y: Default payment (Yes = 1, No = 0)

### Kasutatud allikad:
* https://spark.apache.org/docs/2.2.0/ml-classification-regression.html#random-forest-classifier
* https://spark.apache.org/docs/2.1.0/ml-features.html#vectorassembler
