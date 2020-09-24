package guru.springframework.spring5webapp.boostrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher wizardsOfTheCoast = new Publisher();
        wizardsOfTheCoast.setName("wizards of the Coast");
        wizardsOfTheCoast.setCity("Los Angeles");
        wizardsOfTheCoast.setCity("US-CA");

        publisherRepository.save(wizardsOfTheCoast);

        System.out.println("Publisher Count " + publisherRepository.count());

        Author jace = new Author("Jace", "Beleren");
        Book blueMana = new Book("Cast Blue Mana Spells", "123456");
        jace.getBooks().add(blueMana);
        blueMana.getAuthors().add(jace);

        blueMana.setPublisher(wizardsOfTheCoast);

        authorRepository.save(jace);
        bookRepository.save(blueMana);

        Author liliana = new Author("Liliana", "Vess");
        Book blackMana = new Book("Cast Black Mana Spells", "654987");
        liliana.getBooks().add(blackMana);
        blackMana.getAuthors().add(liliana);

        blackMana.setPublisher(wizardsOfTheCoast);

        authorRepository.save(liliana);
        bookRepository.save(blackMana);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books " + bookRepository.count());
        System.out.println("Publsher Number of books: " + wizardsOfTheCoast.getBooks().size());



    }
}
