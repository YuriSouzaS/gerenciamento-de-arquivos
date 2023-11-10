import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

public class GereciamentoArquivos {
    public static void main(String[] args) {
        String a = "newText.txt";
        // String text = "Este texto é um exemplo.\nEste texto é um exemplo.";
        // read("myfile.txt");
        // getFileInfo("myfile.txt");
        createFile(a);    
        // writeFile(a, text);
        // deleteFile(a);
        // deletePath("c:\\Users\\fulano\\Documents\\arquivos\\test");
    }

    public static void createFile(String file ){
        // criando um novo arquivo, vazio
        try {
            File myObj = new File(file);

            if(myObj.createNewFile()){
                System.out.println(String.format("Arquivo criado: %s", myObj.getName()));
            } else {
                System.out.println("Arquivo já existe.");
            }

        } catch (IOException e){
            System.out.println("Um erro ocorreu.");
            e.printStackTrace();
        }
    }

    public static void writeFile(String file, String conent){
        // escrevendo em um arquivo
        try {
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(conent);
            myWriter.close();
            System.out.println("Aquivo foi reescrito com sucesso.");
        } catch (IOException e ){
            System.out.println("Um erro ocorreu.");
            e.printStackTrace();
        }
    }

    public static void read(String file){
        // lendo arquivos 
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);

            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
        
            myReader.close();
        } catch (FileNotFoundException e) {        
            System.out.println("Um erro ocorreu.");
            e.printStackTrace();
        }
    }

    public static void getFileInfo(String file ){
        // lendo informações do arquivo
        File myObj = new File(file);
        
        if(myObj.exists()){
            System.out.println(String.format("Nome do arquivo: %s", myObj.getName()));
            System.out.println(String.format("caminho: %s", myObj.getAbsolutePath()));
            System.out.println(String.format("Escrita: %s", myObj.canWrite()));
            System.out.println(String.format("Ler: %s", myObj.canRead()));
            System.out.println(String.format("Tamanho do arquivo em bytes: %d", myObj.length()));
        } else {
            System.out.println("O arquivo não existe.");
        }
   }

   public static void deleteFile(String file){
        // deletar arquivo
        File myObj = new File(file);
        
        if(myObj.delete()){
            System.out.println(String.format("Arquivo deletado: %s", myObj.getName()));
        } else {
            System.out.println("Falha ao deletar arquivo.");
        }
   }

   public static void deletePath(String p){
        // deletar pasta
        File myObj = new File(p);
        
        if(myObj.delete()){
            System.out.println(String.format("Pasta %s foi deletada.", myObj.getName()));
        } else {
            System.out.println("Falha ao deletar pasta.");
        }
   }
}