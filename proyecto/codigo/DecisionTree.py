#IMPORT ALL NECESSARY LIBRARIES
import Chefboost as chef
import pandas as pd

archivo = input("INSERT FILE NAMED FOLLOWED BY .CSV:\n")
# READ THE DATA SET FROM THE CSV FILE
df = pd.read_csv(str(archivo))
df.columns = ['ph', 'soil_temperature', 'soil_moisture', 'illuminance', 'env_temperature','env_humidity','Decision']
# print(df.head(10)) #UNCOMMENT IF WANT FIRST 10 ROWS PRINTED OUT


config = {'algorithm':'ID3'} # CONFIGURE THE ALGORITH. CHOOSE BETWEEN ID3, C4.5, CART, Regression
model = chef.fit(df.copy(), config) #CREATE THE DECISION TREE BASED OF THE CONFIGURATION ABOVE

resultados = pd.DataFrame(columns = ["Real", "Predicción"]) #CREATE AN EMPTY PANDAS DATAFRAME
# SAVE ALL REAL VS ESTIMATED VALUES IN THE ABOVE DATAFRAME
for i in range(1,372):
    l = []
    l.append(df.iloc[i]['Decision'])
    feature = df.iloc[i]
    prediction = chef.predict(model, feature)
    l.append(prediction)
    resultados.loc[i] = l
    print(l)
   

# ASK THE USER FOR A NEW RECORD
nuevo = input("INSERT NEW RECORD AS A LIST:\n")
feature = eval(nuevo)
prediction = chef.predict(model, feature)
print(prediction)