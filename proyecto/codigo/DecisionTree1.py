import numpy as np 
import pandas as pd
from sklearn.tree import DecisionTreeClassifier
from sklearn import preprocessing
from sklearn.model_selection import train_test_split
from sklearn import metrics
import matplotlib.pyplot as plt

df = pd.read_csv("data_set.csv")
df.columns = ['ph', 'soil_temperature', 'soil_moisture', 'illuminance', 'env_temperature','env_humidity','Decision']
#print(df.head(10))

X = df[['ph', 'soil_temperature', 'soil_moisture', 'illuminance', 'env_temperature','env_humidity']].values
#print(X[0:5])

y = df["Decision"]
print(y[0:5])

X_trainset, X_testset, y_trainset, y_testset = train_test_split(X, y, test_size=0.2, random_state=3)

rustTree = DecisionTreeClassifier(criterion="entropy", max_depth = 20) #TODO cambiar para ver como cambia la acurracy
print(rustTree) #it shows the default parameters

rustTree.fit(X_trainset,y_trainset)
predTree = rustTree.predict(X_testset)

print (predTree[0:5])
print (y_testset[0:5])

print("DecisionTrees's Accuracy: ", metrics.accuracy_score(y_testset, predTree))