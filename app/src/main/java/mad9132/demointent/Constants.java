package mad9132.demointent;

// TODO class Constants
/**
 * The better way to define constants is to use a Java class.
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 */
public class Constants {

    public static final String  ABOUT_DIALOG_TAG = "About";
    public static final char    DEFAULT_LETTER   = 'A';
    public static final String  LETTERS          = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String  LOG_TAG          = "DEMO-INTENT";
    public static final String  THE_MESSAGE      = "mad9132.demointent.message";
    public static final String  THE_LETTER       = "mad9132.demointent.letter";

    // TODO please read.
    // Pro-tip: prevent instantiation of this class by defining a private no-arg constructor.
    //          Java will not assume the default constructor, because we've defined the no-arg
    //          constructor.
    //          Your project will NOT build if you try this:
    //              Constants constants = new Constants();
    //          Go ahead and try it for your self :)
    private Constants() { }
}
