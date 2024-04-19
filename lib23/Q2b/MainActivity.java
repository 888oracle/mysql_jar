public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        List<Book> books = new ArrayList<>();
        books.add(new Book("Book1", "Author1"));
        books.add(new Book("Book2", "Author2"));
        books.add(new Book("Book3", "Author3"));

        bookAdapter = new BookAdapter(this, books);
        listView.setAdapter(bookAdapter);
    }
}