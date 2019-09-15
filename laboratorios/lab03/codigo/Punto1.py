import pandas as pd

Fund    = pd.read_csv("NOTAS ST0242.csv")
Estruc1 = pd.read_csv("NOTAS ST0245.csv")
Estruc  = pd.read_csv("NOTAS ST0247.csv")


Fund    = Fund[["nombre", "código", "Cod. Materia", "Semestre", "Nota Definitiva"]]
Estruc1 = Estruc1[["nombre", "código", "Cod. Materia", "Semestre", "Nota Definitiva"]]
Estruc  = Estruc[["nombre", "código", "Cod. Materia", "Semestre", "Nota Definitiva"]]

Fund    = Fund.drop_duplicates(['código'],keep = 'last')
Estruc1 = Estruc1.drop_duplicates(['código'], keep = 'last')
Estruc  = Estruc.drop_duplicates(['código'], keep = 'last')

#print(Fund.head())

def buscarAlumno(nombre):
    for i in range(191):
        try:
            if Fund.iloc[i][0] == nombre:
                print("La nota en la materia: " + str(Fund.iloc[i][2])+ " es: " + str(Fund.iloc[i][4]))
                #print(str(Fund.iloc[i][0]))
                break

        except:
            print("No está en curso ST0242")
            break

    for j in range(165):
        try:
            if Estruc1.iloc[j][0] == nombre:
                print("La nota en la materia: " + str(Estruc1.iloc[j][2])+ " es: " + str(Estruc1.iloc[j][4]))
                #print(str(Estruc1.iloc[j][0]))
                break
        except:
            print("No está en curso ST0245")
            break

    for k in range(74):
        try:
            if Estruc.iloc[k][0] == nombre:
                print("La nota en la materia: " + str(Estruc.iloc[k][2])+ " es: " + str(Estruc.iloc[k][4]))
                #print(str(Estruc.iloc[k][0]))
                break
        except:
            print("No está en curso ST0247")
            break

def buscarGrupo(codigo, semestre):
    if(codigo == "ST0242"):
        for i in range(190):
            if Fund.iloc[i][3] == int(semestre):
                print("Estudiante " + Fund.iloc[i][0] + " está registrado en ST0242 para el semestre "
                + str(semestre) + " con nota definitiva " + str(Fund.iloc[i][4]))
    elif codigo == "ST0245":
        for j in range(164):
            if Estruc1.iloc[j][3] == int(semestre):
                print("Estudiante " + Estruc1.iloc[j][0] + " está registrado en ST0245 para el semestre "
                + str(semestre) + " con nota definitiva " + str(Estruc1.iloc[j][4]))
    else:
        for k in range(73):
            if Estruc.iloc[k][3] == int(semestre):
                print("Estudiante " + Estruc.iloc[k][0] + " está registrado en ST0247 para el semestre "
                + str(semestre) + " con nota definitiva " + str(Estruc.iloc[k][4]))

buscarAlumno("Columbano")
buscarGrupo("ST0247", 20142)
