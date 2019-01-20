package expressionClasses;

public class RegularExpr {
	
	public static boolean matchToPattern(String pattern, String chain) {
		return chain.matches(pattern);
	}
}
