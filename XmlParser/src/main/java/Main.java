
public class Main {
    public static void main(String[] args) {
        Reader readerModule = new Reader(args[0]);
        Parser parserModule = new Parser();
        Writer writerModule = new Writer();

        parserModule.DocumentParse(readerModule.GetWorkbook());
        writerModule.SaveData(parserModule.GetData());
        writerModule.CloseFile();

    }
}
