import pandas as pd

dataVertices = pd.read_csv('Vertices.csv')
dataVertices.index = [i for i in range(5)]
dataVertices.columns = ["ID","CoordenadaX","CoordenadaY","Nombre"]
#print(dataVertices.head())

dataArcos = pd.read_csv('Arcos.csv')
dataArcos.index = [i for i in range(16)]
dataArcos.columns = ["ID","ID1","Distancia","Nombre"]
#print(dataArcos.head(16))

diccArcos = {}
for i in range(16):
    diccArcos[(dataArcos.iloc[i]['ID'],dataArcos.iloc[i]['ID1'])] = [dataArcos.iloc[i]['Distancia'], dataArcos.iloc[i]['Nombre']]

print("El diccionario de los arcos es:")
print(diccArcos)
# print(diccArcos[(2,1)])

diccVert = {}
for i in range(5):
    diccVert[(dataVertices.iloc[i]['ID'])] = [dataVertices.iloc[i]['CoordenadaX'], dataVertices.iloc[i]['CoordenadaY'], dataVertices.iloc[i]["Nombre"]]

print("El diccionario de los vertices es:")
print(diccVert)
# print(diccVert[2])
    
    