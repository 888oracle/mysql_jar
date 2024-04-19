public class BookAdapter extends ArrayAdapter<Book> {
    private Context context;
    private List<Book> books;

    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
        this.context = context;
        this.books = books;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            rowView = LayoutInflater.from(context).inflate(R.layout.rowlayout, parent, false);
        }

        Book book = books.get(position);

        TextView bookNameView = (TextView) rowView.findViewById(R.id.book_name);
        bookNameView.setText(book.getBookName());

        TextView authorNameView = (TextView) rowView.findViewById(R.id.author_name);
        authorNameView.setText(book.getAuthorName());

        return rowView;
    }
}