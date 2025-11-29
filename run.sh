#!/bin/bash

echo "🔧 Compilando o projeto..."

javac -cp "lib/mysql-connector-j-9.5.0.jar" -d out $(find src -name "*.java")

if [ $? -ne 0 ]; then
    echo "❌ Erro na compilação. Verifique o código."
    exit 1
fi

echo "🚀 Iniciando o sistema..."

java -cp "out:lib/mysql-connector-j-9.5.0.jar" Main


