/*
8.
문제 설명
길이가 같은 두 문자열 str1과 str2가 주어집니다.

두 문자열의 각 문자가 앞에서부터 서로 번갈아가면서 한 번씩 등장하는 문자열을 만들어 return 하는 solution 함수를 완성해 주세요.

제한사항
1 ≤ str1의 길이 = str2의 길이 ≤ 10
str1과 str2는 알파벳 소문자로 이루어진 문자열입니다.
*/

//내 솔루션
class Solution {
    public String solution(String str1, String str2) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < str1.length();i++){
            char a = str1.charAt(i);
            char b = str2.charAt(i);
            sb.append(a);
            sb.append(b);
        }
        
        return sb.toString();
    }
}
//다른 방법 솔루션
class Solution {
    public String solution(String str1, String str2) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i < str1.length();i++){
            sb.append(str1.charAt(i)).append(str2.charAt(i));
        }
        return sb.toString();
    }
}

/*
9.
문제 설명
문자들이 담겨있는 배열 arr가 주어집니다. arr의 원소들을 순서대로 이어 붙인 문자열을 return 하는 solution함수를 작성해 주세요.

제한사항
1 ≤ arr의 길이 ≤ 200
arr의 원소는 전부 알파벳 소문자로 이루어진 길이가 1인 문자열입니다.
*/

//내 솔루션
class Solution {
    public String solution(String[] arr) {
        StringBuffer sb = new StringBuffer();
        for(String a : arr){
            sb.append(a);
        }
        return sb.toString();
    }
}

//다른 사람 솔루션
class Solution {
    public String solution(String[] arr) {
        return String.join("", arr);
    }
}
//또 다른 솔루션
class Solution {
    public String solution(String[] arr) {
        String answer = "";

        for(String a : arr) {
            answer += a;
        }

        return answer;
    }
}

/*
10.
문제 설명
문자열 my_string과 정수 k가 주어질 때, my_string을 k번 반복한 문자열을 return 하는 solution 함수를 작성해 주세요.

제한사항
1 ≤ my_string의 길이 ≤ 100
my_string은 영소문자로만 이루어져 있습니다.
1 ≤ k ≤ 100
*/
//내 풀이
class Solution {
    public String solution(String my_string, int k) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i < k;i++) {
            sb.append(my_string);
        }
        return sb.toString();
    }
}
// 또 다른 솔루션
class Solution {
    public String solution(String my_string, int k) {
        return my_string.repeat(k);
    }
}

/*
11.
문제 설명
연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.

12 ⊕ 3 = 123
3 ⊕ 12 = 312
양의 정수 a와 b가 주어졌을 때, a ⊕ b와 b ⊕ a 중 더 큰 값을 return 하는 solution 함수를 완성해 주세요.

단, a ⊕ b와 b ⊕ a가 같다면 a ⊕ b를 return 합니다.
제한사항
1 ≤ a, b < 10,000
*/

//내 풀이
class Solution {
    public int solution(int a, int b) {
        String c = a + "" + b;
        String d = b + "" + a;
        int e = Integer.parseInt(c);
        int f = Integer.parseInt(d);
        
        if(e >= f){
            return e;
        } else {
            return f;
        }       
    }
}
//다른 솔루션
class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int aLong = Integer.parseInt(""+a+b);
        int bLong = Integer.parseInt(""+b+a);
        answer = aLong > bLong ? aLong : bLong;
        
        return answer;
    }
}

/*
12.
문제 설명

연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다.
예시:
• 12 ⊕ 3 = 123
• 3 ⊕ 12 = 312

양의 정수 a와 b가 주어졌을 때, a ⊕ b와 2 * a * b 중 더 큰 값을 return하는 solution 함수를 완성해 주세요.
조건: a ⊕ b와 2 * a * b가 같으면 a ⊕ b를 return 합니다.
*/

//내 풀이
class Solution {
    public int solution(int a, int b) {
        String fir = a + "" + b;
        int second = 2 * a * b;
        int first = Integer.parseInt(fir);
        
        return first >= second ? first : second;
    }
}
//다른 솔루션
class Solution {
    public int solution(int a, int b) {
        return Math.max(Integer.parseInt(String.valueOf(a)+String.valueOf(b)), 2*a*b);
    }
}
/*
Math.max() 메소드 활용: Java의 Math 클래스에서 제공하는 max() 메소드는 두 값 중 더 큰 값을 자동으로 반환합니다. 
Math.max(값1, 값2) 형태로 사용하며, 삼항연산자나 if-else문 없이 간결하게 최댓값을 구할 수 있습니다.
*/

/*
13.
문제 설명

정수 num과 n이 매개 변수로 주어질 때, num이 n의 배수이면 1을 
return n의 배수가 아니라면 0을 return하도록 solution 함수를 완성해주세요.
*/

//내 풀이
class Solution {
    public int solution(int num, int n) {
        return num % n == 0 ? 1 : 0;
    }
}

/*
14.
문제 설명

정수 `number`와 `n`, `m`이 주어집니다. `number`가 `n`의 배수이면서 
`m`의 배수이면 1을 아니라면 0을 return하도록 solution 함수를 완성해주세요. 
*/

//내 풀이
class Solution {
    public int solution(int number, int n, int m) {
        return (number % n == 0) && (number % m == 0) ? 1 : 0;
    }
}

/*
15.
문제 설명

양의 정수 `n`이 매개변수로 주어질 때, `n`이 홀수라면 `n` 이하의 홀수인 모든 양의 정수의 합을 
return 하고 `n`이 짝수라면 `n` 이하의 짝수인 모든 양의 정수의 제곱의 합을 return 하는 
solution 함수를 작성해 주세요.
*/

//내 풀이
class Solution {
    public int solution(int n) {
        int sum = 0;
        if(n % 2 == 1){
            for(int i=0;i<n;i+=2){
                sum += n-i;
            }
            return sum;
        } else {
            for(int i=0;i<=n;i+=2){
                sum += (n-i)*(n-i);
            }
            return sum;
        }
    }
}
//다른 풀이
class Solution {
    public int solution(int n) {
        int answer = 0;

            for(int i = n; i >= 0; i -= 2)
                answer += (n % 2 == 0) ? i * i : i;

        return answer;
    }
}

/*
16.
### **문제 설명**

문자열에 따라 다음과 같이 두 수의 크기를 비교하려고 합니다.

- 두 수가 `n`과 `m`이라면
    - ">", "=" : `n` >= `m`
    - "<", "=" : `n` <= `m`
    - ">", "!" : `n` > `m`
    - "<", "!" : `n` < `m`

두 문자열 `ineq`와 `eq`가 주어집니다. `ineq`는 "<"와 ">"중 하나고, `eq`는 "="와 "!"중 
하나입니다. 그리고 두 정수 `n`과 `m`이 주어질 때, `n`과 `m`이 
`ineq`와 `eq`의 조건에 맞으면 1을 아니면 0을 return하도록 solution 함수를 완성해주세요.
*/

//내 풀이
class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        if(ineq.equals("<")){
            if(eq.equals("=")){
                return n <= m ? 1 : 0;
            } else {
                return (n < m) ? 1 : 0;
            } 
        } else {
            if(eq.equals("=")){
                return n >= m ? 1 : 0;
            } else {
                return (n > m) ? 1 : 0;
            }
        }
    }
}