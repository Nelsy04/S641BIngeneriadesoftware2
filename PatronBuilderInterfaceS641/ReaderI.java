public class ReaderI {
    
    //Atributos 
     private String element;
    private Converter converter;

    public Reader(String element, Converter converter){
        this.element = element;
        this.converter = converter;
    }

    //metodos 
    public void parseInput(){
        switch (element) {
            case "LINE":
                converter.makeLine();
                break;
            case "PRAGRAPH":
                converter.makeParagraph();
                break;
            case "TABLE":
                converter.makeTable();
                break;
        
            default:
            System.out.println("Opcion no valida");
                break;
        }
    }
}
