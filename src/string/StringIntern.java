package string;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class StringIntern {  
    public static void main(String[] args) {          
        String s1 = "Javatpoint";  
        String s2 = s1.intern();  
        String s3 = new String("Javatpoint");  
        String s4 = s3.intern(); 
        System.out.println(s2==s3); // 
        System.out.println(s2==s4); //     
        System.out.println(s3==s4); //  
        System.out.println(s1==s2); // 
        System.out.println(s1==s3); //
        System.out.println(s1==s4); //     
        
        int a[]= {3,4,5,6,7,8};
        
        Set<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toSet());
        System.out.println(list);
     
    }  
    
}
