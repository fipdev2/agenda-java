# Use a imagem oficial do OpenJDK
FROM openjdk:17-jdk-slim

# Crie um diretório de trabalho dentro do container
WORKDIR /app

# Copie o código fonte para o diretório de trabalho no container
COPY ./src /app/src

# Defina o comando padrão para rodar sua aplicação Java
CMD ["bash"]
