package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComUtilsService {
    private ComUtils comUtils;

    public ComUtilsService(InputStream inputStream, OutputStream outputStream) throws IOException {
        comUtils = new ComUtils(inputStream, outputStream);
    }

    public void writeTest() {
        //TODO: put your code here
        String name =  "Reyes Chacon";
        int years = 24;
        String comment = "i'm already lost";
        char ch='a';
        
        try {
            comUtils.write_string_variable(20, name);
            comUtils.write_int32(years);
            comUtils.write_string(comment);
            comUtils.writeChar(ch);
            

        } catch (IOException ex) {
            Logger.getLogger(ComUtilsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public String readTest() {
        String result = "";
        
        try {
            //TODO: put your code here
            result = comUtils.read_string_variable(20) + comUtils.read_int32() + comUtils.read_string()+ comUtils.readChar();
        } catch (IOException ex) {
            Logger.getLogger(ComUtilsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return result;
    }
    
    /**
     * NOTE: String[20] pero en ComUtils tenemos STRSIZE = 40.
     * 
     * Lo que hace es: write.string-variable(20, "Nuria") escribe 20 ceros, la longitud del nombre y el nombre
     * 000.0005Nuria
     * 
     * En nuestro caso, escribe: 00000000000000000012Reyes Chacon   i'm already lost
     *
     * Si escribimos el comentario antes que el entero, aparece: Reyes Chacon1764191520already lost
     *
     * Si usamos read_string en lugar de read_string_variable, aparece:  SEVERE: null java.io.IOException: Broken Pipe
     *
     *
     *
     *
     */



}
