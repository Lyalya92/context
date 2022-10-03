import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.context.Cart;
import ru.geekbrains.context.ProductRepository;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.geekbrains.context");

        ProductRepository productRepository = context.getBean(ProductRepository.class);
        System.out.println("Available products");
        productRepository.getListOfProducts().stream().forEach(System.out::println);
        System.out.println();

        Cart cart1 = context.getBean(Cart.class);
        cart1.getToCart(145387L);
        cart1.getToCart(890734L);
        cart1.getToCart(395371L);
        System.out.println("Cart 1:");
        cart1.showCartContent();

        cart1.removeFromCart(395371L);
        System.out.println("Cart 1:");
        cart1.showCartContent();

        Cart cart2 = context.getBean(Cart.class);
        cart2.getToCart(224475L);
        cart2.getToCart(395371L);
        System.out.println("Cart 2:");
        cart2.showCartContent();

    }
}
