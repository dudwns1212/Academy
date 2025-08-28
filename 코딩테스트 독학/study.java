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
/*
## 17. flag에 따른 다른 값 반환하기

### **문제 설명**

두 정수 `a`, `b`와 boolean 변수 `flag`가 매개변수로 주어질 때, `flag`가 true면 `a` + `b`를 false면 `a` - `b`를 return 하는 solution 함수를 작성해 주세요.

### 내 풀이

```java */
class Solution {
    public int solution(int a, int b, boolean flag) {
        return flag ? (a+b) : (a-b);
    }
}
/*
```

너무 쉬워서 설명은 생략하겠음..

## 18. 코드 처리하기

### **문제 설명**

문자열 `code`가 주어집니다.

`code`를 앞에서부터 읽으면서 만약 문자가 "1"이면 `mode`를 바꿉니다. `mode`에 따라 `code`를 읽어가면서 문자열 `ret`을 만들어냅니다.

`mode`는 0과 1이 있으며, `idx`를 0 부터 `code의 길이 - 1` 까지 1씩 키워나가면서 `code[idx]`의 값에 따라 다음과 같이 행동합니다.

- `mode`가 0일 때
    - `code[idx]`가 "1"이 아니면 `idx`가 짝수일 때만 `ret`의 맨 뒤에 `code[idx]`를 추가합니다.
    - `code[idx]`가 "1"이면 `mode`를 0에서 1로 바꿉니다.
- `mode`가 1일 때
    - `code[idx]`가 "1"이 아니면 `idx`가 홀수일 때만 `ret`의 맨 뒤에 `code[idx]`를 추가합니다.
    - `code[idx]`가 "1"이면 `mode`를 1에서 0으로 바꿉니다.

문자열 `code`를 통해 만들어진 문자열 `ret`를 return 하는 solution 함수를 완성해 주세요.

단, 시작할 때 `mode`는 0이며, return 하려는 `ret`가 만약 빈 문자열이라면 대신 "EMPTY"를 return 합니다.

### 내 풀이

```java */
class Solution {
    public String solution(String code) {
        StringBuffer sb = new StringBuffer();
        int mode = 0;
        int i = 0;
        for(char str : code.toCharArray()){           
            if(mode==0){
                if(str == '1'){
                    mode = 1;
                }else if((str != '1') && (i % 2  == 0)){
                    sb.append(str);
                }
            } else {
                if(str == '1'){
                    mode = 0;
                }else if((str != '1') && (i % 2 == 1)){
                    sb.append(str);
                }
            }
            i++;
        }
        String ret = sb.toString();
        return ret.isEmpty() ? "EMPTY" : ret;
    }
}
/*
```

StringBuffer로 문자열을 메모리 소모 없이 이어붙이고 mode와 i를 정의

for문으로 code의 char를 처음부터 char str에 대입하여 반복문 실행

나머지는 조건대로고 i++ 추가해서 홀짝 구별

마지막으로 sb를 문자열로 바꿔주고 isEmpty()를 사용해 삼항연산으로 값 출력

## 19. 등차수열의 특정한 항만 더하기

### **문제 설명**

두 정수 `a`, `d`와 길이가 n인 boolean 배열 `included`가 주어집니다. 첫째항이 `a`, 공차가 `d`인 등차수열에서 `included[i]`가 i + 1항을 의미할 때, 이 등차수열의 1항부터 n항까지 `included`가 true인 항들만 더한 값을 return 하는 solution 함수를 작성해 주세요.

### 내 풀이

```java */
class Solution {
    public int solution(int a, int d, boolean[] included) {
        int sum = 0;
        for(int i = 0;i<included.length;i++){
            if(included[i]){
                int term = a + d*i;
                sum += term;
            }
        }
        return sum;
    }
    
}
/*
```

return 할 int 값 sum 정의

for문으로 0~included.length-1 까지 반복문 실행

term → 각 실행된 true 항의 값

sum += term으로 값 누적하여 retrun;

### 다른 사람 풀이

```java
*/
import java.util.stream.IntStream;

class Solution {
    public int solution(int a, int d, boolean[] included) {
        return IntStream.range(0, included.length).map(idx -> included[idx]?a+(idx*d):0).sum();
    }
}
/*
```

`IntStream.range(0, included.length)`

- **동작**: 0부터 `included.length-1`까지의 정수 스트림 생성
- **예시**: included.length가 5라면 → [0, 1, 2, 3, 4] 스트림

`.map(idx -> included[idx] ? a + (idx * d) : 0)`

**람다식 분해:**

- `idx`: 현재 처리 중인 인덱스 (0, 1, 2, 3, 4...)
- `included[idx]`: 해당 인덱스의 포함 여부 확인
- **삼항연산자**: `조건 ? 참일때값 : 거짓일때값`
- `included[idx]`가 **true**인 경우:
    - `a + (idx * d)` 계산 → 등차수열의 idx번째 항
- `included[idx]`가 **false**인 경우:
    - `0` 반환 → 합계에 영향 없음

`.sum()`

- 스트림의 모든 요소를 더해서 최종 결과 반환

문제 설명
1부터 6까지 숫자가 적힌 주사위가 세 개 있습니다. 세 주사위를 굴렸을 때 나온 숫자를 각각 a, b, c라고 했을 때 얻는 점수는 다음과 같습니다.

세 숫자가 모두 다르다면 a + b + c 점을 얻습니다.
세 숫자 중 어느 두 숫자는 같고 나머지 다른 숫자는 다르다면 (a + b + c) × (a2 + b2 + c2 )점을 얻습니다.
세 숫자가 모두 같다면 (a + b + c) × (a2 + b2 + c2 ) × (a3 + b3 + c3 )점을 얻습니다.
세 정수 a, b, c가 매개변수로 주어질 때, 얻는 점수를 return 하는 solution 함수를 작성해 주세요.

내 풀이 */
class Solution {
    public int solution(int a, int b, int c) {
        int plus1 = a + b + c;
        double plus2_1 = (Math.pow(a,2) + Math.pow(b,2) + Math.pow(c,2));
        int plus2 = (int) plus2_1 * plus1;
        double plus3_1 = (Math.pow(a,3) + Math.pow(b,3) + Math.pow(c,3));
        int plus3 = (int) plus3_1 * plus2;
        
        if(a == b && a == c){
            return plus3;
        } else if(a != b && b != c && a != c ) {
            return plus1;
        } else {
            return plus2;
        }
    }
}
/* 
제곱의 숫자는 Math.pow() 함수로 처리, 미리 plus1 , 2 , 3 값을 만들어놓고 if문을 간단하게 함

다른 풀이
*/
class Solution {
    public int solution(int a, int b, int c) {
        int answer = 1;

        int count = 1;
        if(a == b || a == c || b == c) {
            count++;
        }

        if(a == b && b == c) {
            count++;
        }

        for(int i = 1; i <= count; i++) {
            answer *= (pow(a,i)+pow(b,i)+pow(c,i));
        }

        return answer;
    }

    private int pow(int a, int b) {
        if(b == 0) return 1;
        return a * pow(a, b-1);
    }
}
/* Math.pow()를 직접 만드심 이 문제에만 구현되도록
count는 1부터 처음에 if 문을 하나씩 만나면서 조건에 부합하면 3까지 늘어나고
for문으로 *=로 answer에 값을 누적해서 곱합니다
그리고 return 

문제 설명
정수가 담긴 리스트 num_list가 주어질 때, 모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 
크면 0을 return하도록 solution 함수를 완성해주세요.

내 풀이
*/
class Solution {
    public int solution(int[] num_list) {
        int sumPlus = 0;
        int sumDo = 1;
        for(int a : num_list){
            sumPlus += a;
        }
        
        int sumPlus2 = sumPlus * sumPlus;
        
        for(int a : num_list){
            sumDo *= a;
        }
        
        if(sumPlus2 > sumDo){
            return 1;
        } else {
            return 0;
        }
    }
}
/* 이제와서 생각해보니 마지막은 삼항연산으로 처리
return sumPlus2 > sumDo ? 1 : 0;

다른사람 풀이
*/
class Solution {
    public int solution(int[] num_list) {
        int answer = 0;

        int sum  = 0;
        int mult = 1;

        for(int i : num_list) {
            sum += i;
            mult *= i;
        }

        answer = Math.pow(sum,2) > mult ? 1 : 0;

        return answer;
    }
}
/* 이렇게 for문 안에 둘다 넣을 수 있었음
문제 설명
정수가 담긴 리스트 num_list가 주어집니다. num_list의 홀수만 순서대로 이어 
붙인 수와 짝수만 순서대로 이어 붙인 수의 합을 return하도록 solution 함수를 완성해주세요.

내 풀이
*/
class Solution {
    public int solution(int[] num_list) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        
        for(int i : num_list){
            if(i%2 == 0){
                sb2.append(i);    
            } else {
                sb1.append(i);
            }
        }
        int hol = Integer.parseInt(sb1.toString());
        int jjak = Integer.parseInt(sb2.toString());
        return hol+jjak;
        
    }
}
/*
문제 설명
정수 리스트 num_list가 주어질 때, 마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을 마지막 원소가 그전 
원소보다 크지 않다면 마지막 원소를 두 배한 값을 추가하여 return하도록 solution 함수를 완성해주세요.

내 풀이
*/

