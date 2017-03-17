import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;





public class Passwords {

	public static void main(String[] args) throws IOException {
		Stream<String> pws = 
				Files.lines(Paths.get("data", "passwords.txt"));
		
		/*int count = pws.map(pw -> pw.toLowerCase())
				.filter(pw -> pw.contains("fuck"))
				.reduce(0, (acc, x) -> acc + 1,
						(acc1, accr) -> acc1 + accr);
		*/
		Iterator<String> iter = pws.iterator();
		
		//System.out.printf("There are %d passwords with f*ck in it", count);
		
		int ret = 0; //This is the easier way
		int fuq = 0;
		String cur = "";
		while(iter.hasNext()) {
			cur = iter.next();
			if(cur.length() > ret) {
				ret = iter.next().length(); //minimum password length
			}
			if(cur.toLowerCase().contains("fuck")) {
				fuq++;
			}
		}
		System.out.println(ret);
		System.out.println(fuq); 

	}

}
