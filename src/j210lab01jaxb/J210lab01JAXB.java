package j210lab01jaxb;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class J210lab01JAXB {

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Library.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Library library = (Library)unmarshaller.unmarshal(new File("library.xml"));
            
            System.out.println("библиотека: " + library.getName());
            
            ArrayList<Book> books = library.getBooks();
            for(Book b : books){
                System.out.println("Книга: " + b.toString());
            }

        } catch (JAXBException ex) {
            Logger.getLogger(J210lab01JAXB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            JAXBContext context = JAXBContext.newInstance(Library.class);
            Library library = new Library();
            library.setName("Эпосы");
            ArrayList<Book> books = new ArrayList<>();
            Book book = new Book();
            book.setIsbn("22222222222");
            book.setTitle("Одиссея");
            book.setAuthor("Гомер");
            books.add(book);
            
            book.setIsbn("33333333333");
            book.setTitle("Махабхарата");
            book.setAuthor("Вьяса");
            books.add(book);
            
            library.setBooks(books);
            
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(library, System.out);
            
        } catch (JAXBException ex) {
            Logger.getLogger(J210lab01JAXB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
