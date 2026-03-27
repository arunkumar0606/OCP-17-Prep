package Ch_14;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Example {
    public static void main(String[] args) throws IOException {
        //Absolute path - path starting with / or drive: is absolute
        //relative - other paths


        //Creating a file using
        File f1= new File("/txt");

        //Creating path
        Path p1 = Path.of("/some/some/some");
        Path p2 = Paths.get("/some/some/some");
        Path zooPath1 = FileSystems.getDefault()
                .getPath("/home/tiger/data/stripes.txt");

        File file = new File("rabbit");
        Path nowPath = file.toPath();
        File backToFile = nowPath.toFile();

        Path p3 = Path.of("Ch_14/Hello.txt");
        Files.list(p3).forEach(x-> System.out.println(x));

        //Paths are immutable
        Path p = Path.of("whale");
        p.resolve("krill");
        System.out.println(p); // whale

        //resolve() ->concat paths
        //relativize() ->make common path
        //throws exception if both are mixed(absolute,relative)  or both don't have common root
        //normalize()


        /*
        isSameFile()
        mismatch() -> index of first mismatch
         */

    }
}
class IOStreams{
    /*
    Byte streams - reads 0 & 1 -> inputStream , outputStream
    Character streams - reads chars -> reader ,writer
     */

    public static void main(String[] args) throws IOException {
        char[] buffer = new char[8];
        int count = 0;

        try (FileReader in = new FileReader("ch_14/in.txt");
             FileWriter out = new FileWriter("ch_14/out.txt")) {

            while ((count = in.read(buffer)) != -1) {
                out.write(buffer);
            }
        }
    }
    /*
    Four main class
    InputStream Abstract class for all input byte streams
    OutputStream Abstract class for all output byte streams
    Reader Abstract class for all input character streams
    Writer Abstract class for all output character streams
     */
    private void readLazily(Path path) throws IOException {
        try (Stream<String> s = Files.lines(path)) {
            s.forEach(System.out::println);
        }
    }

    //Files.readAllLines() vs. Files.lines()
    //readAllLines() -> read entire content into memory
    //lines() -> lazy line by line

    //serialization , deserialization
    /*
    Console c= System.console()
    mark() -> can reset to marked position
    skip() -> skip upcoming reads
    Java nio streams uses depth first search
    walk() method

     */
}