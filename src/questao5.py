def inversor_de_string(s):
    string_invertida = ''
    for i in range(len(s) - 1, -1, -1):#pega o index
        string_invertida += s[i]

    return string_invertida


def main():
    resultado = inversor_de_string(input("Digite uma string para inverter:\n"))
    print("String invertida:", resultado)

if __name__ == "__main__":
    main()