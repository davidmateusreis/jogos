<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Table</title>
   
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

</head>
<body>
    <h2>Todos os Jogos</h2>
    <br>
        <table class="table">
            <thead>
                <tr>
                    <th>Título</th>
                    <th>Desenvolvedor</th>
                    <th>Publicador</th>
                    <th>Gênero</th>
                    <th>Região</th>
                    <th>Ações</th>    
                </tr>
            </thead>
            <tbody>
                <?php
                $servername = "localhost";
                $username = "root";
                $password = "";
                $database = "jogos";

                $connection = new mysqli($servername, $username, $password, $database);

                if ($connection->connect_error) {
                    die("connection failed: " . $connection->connect_error);
                }

                $sql = "SELECT * FROM jogos";
                $result = $connection->query($sql);

                if (!$result) {
                    die("Invalid query: " . $connection->connect_error);
                }

                while($row = $result->fetch_assoc()) {
                    echo "<tr>
                    <td>" . $row["titulo"] . "</td>
                    <td>" . $row["desenvolvedor"] . "</td>
                    <td>" . $row["publicador"] . "</td>
                    <td>" . $row["genero"] . "</td>
                    <td>" . $row["regiao"] . "</td>
                    <td>
                        <a class='btn btn-primary btn-sm' href='update'>Update</a>
                        <a class='btn btn-danger btn-sm' href='delete'>Delete</a>
                    </td>
                </tr>"; 
                }
                ?>
            </tbody>
        </table>
</body>
</html>