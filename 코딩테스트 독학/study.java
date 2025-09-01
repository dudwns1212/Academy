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

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length+1];
        
        for(int i=0;i<num_list.length;i++){
            answer[i]=num_list[i];
        }
        
        int last = num_list[num_list.length-1];
        int before = num_list[num_list.length-2];
        
        if(last > before) {
            answer[answer.length-1] = last-before;
            return answer;
        } else {
            answer[answer.length-1] = last * 2;
            return answer;
        }
            
    }
}
/*
많이 어려웠음 일단 return값이 int[]이므로 int값을 가지는 배열을 리턴해야됨
list의 경우는 불변값이므로 새로운 int[]를 생성해서 num_list.length+1 길이의 값을 가지는 배열을 생성
나머지는 문제대로 비교하고 마지막에 if문으로 answer의 마지막값에 해당하는 값을 넣어줌
*/


/*
문제 설명
정수 n과 문자열 control이 주어집니다. control은 "w", "a", "s", "d"의 4개의 문자로 이루어져 있으며, control의 앞에서부터 순서대로 문자에 따라 n의 값을 바꿉니다.

"w" : n이 1 커집니다.
"s" : n이 1 작아집니다.
"d" : n이 10 커집니다.
"a" : n이 10 작아집니다.
위 규칙에 따라 n을 바꿨을 때 가장 마지막에 나오는 n의 값을 return 하는 solution 함수를 완성해 주세요.

내 풀이
*/
class Solution {
    public int solution(int n, String control) {
        int sum = 0;
        for(char a : control.toCharArray()) {
            if(a == 'w'){
                n+=1;
            } else if(a == 's'){
                n-=1;
            } else if(a == 'd') {
                n+=10;
            } else if(a == 'a') {
                n-=10;
            }
            
        }
        return n;
    }
}
//for문을 이용 controll.toCharArray() 를 사용해서 char a값에 해당 문자열의 문자를 하나씩 대입하여 for문 반복
//n값을 누적하여 해당 조건에 맞게 더하고 뺌

/*
문제 설명
정수 배열 numLog가 주어집니다. 처음에 numLog[0]에서 부터 시작해 "w", "a", "s", "d"로 이루어진 문자열을 입력으로 받아 순서대로 다음과 같은 조작을 했다고 합시다.

"w" : 수에 1을 더한다.
"s" : 수에 1을 뺀다.
"d" : 수에 10을 더한다.
"a" : 수에 10을 뺀다.
그리고 매번 조작을 할 때마다 결괏값을 기록한 정수 배열이 numLog입니다. 즉, numLog[i]는 numLog[0]로부터 총 i번의 조작을 가한 결과가 저장되어 있습니다.

주어진 정수 배열 numLog에 대해 조작을 위해 입력받은 문자열을 return 하는 solution 함수를 완성해 주세요.

내 풀이
*/
class Solution {
    public String solution(int[] numLog) {
        StringBuffer sb = new StringBuffer();
        int n = numLog[0];
        
        for(int i=1;i<numLog.length;i++){
            if(numLog[i]-numLog[i-1] == 1){
                sb.append("w");
            } else if(numLog[i]-numLog[i-1] == -1){
                sb.append("s");
            } else if(numLog[i]-numLog[i-1] == 10){
                sb.append("d");
            } else if(numLog[i]-numLog[i-1] == -10){
                sb.append("a");
            }
        }
        String output = sb.toString();
        return output;
        
    }
}
// 다른사람 풀이
class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        for(int i=1; i<numLog.length; i++){
            int j = numLog[i-1] - numLog[i];
            switch(j){
                case -1 : answer+='w'; break;
                case 1 : answer+='s'; break;
                case -10 : answer+='d'; break;
                case 10 : answer+='a'; break;
            }
        }
        return answer;
    }
}
/*
문제 설명
정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [i, j] 꼴입니다.

각 query마다 순서대로 arr[i]의 값과 arr[j]의 값을 서로 바꿉니다.

위 규칙에 따라 queries를 처리한 이후의 arr를 return 하는 solution 함수를 완성해 주세요.

내 풀이
*/
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = Arrays.copyOf(arr, arr.length);

        for (int[] query : queries) {
            int i = query[0];
            int j = query[1];

            int temp = answer[i];
            answer[i] = answer[j];
            answer[j] = temp;
        }

        return answer;
    }
}
/*
## 22. 배열 원소 교체하기 (Swap Elements)

### **문제 설명**

정수 배열 `arr`와 2차원 정수 배열 `queries`이 주어집니다. `queries`의 원소는 각각 하나의 query를 나타내며, `[i, j]` 꼴입니다.

각 query마다 순서대로 `arr[i]`의 값과 `arr[j]`의 값을 서로 바꿉니다.

위 규칙에 따라 `queries`를 처리한 이후의 `arr`를 return 하는 solution 함수를 완성해 주세요.

### **내 풀이**
*/
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = Arrays.copyOf(arr, arr.length);
        
        for (int[] query : queries) {
            int i = query[0];
            int j = query[1];
            
            int temp = answer[i];
            answer[i] = answer[j];
            answer[j] = temp;
        }
        
        return answer;
    }
}
/*
### **코드 상세 분석**

### 1. 배열 복사(굳이 할 필요 없는 작업, 그냥 arr 써도 됨)

```java
int[] answer = Arrays.copyOf(arr, arr.length);
```

- **목적**: 원본 배열을 보존하면서 작업용 배열을 생성
- **`Arrays.copyOf(배열, 길이)`**: 지정된 배열을 새로운 배열로 복사
- **why**: 원본 `arr`를 직접 수정하지 않고, 복사본에서 작업 수행

### 2. Enhanced For문 (향상된 for문)

```java
for (int[] query : queries) {
```

- **동작**: `queries` 2차원 배열의 각 행을 `query` 배열로 순차 접근
- **예시**: `queries = [[0,3], [1,2], [1,4]]`라면
    - 1회전: `query = [0,3]`
    - 2회전: `query = [1,2]`
    - 3회전: `query = [1,4]`

### 3. 인덱스 추출

```java
int i = query[0];  // 첫 번째 인덱스
int j = query[1];  // 두 번째 인덱스
```

- **동작**: 각 query에서 교체할 두 위치의 인덱스를 추출
- **예시**: `query = [0,3]`이면 `i=0, j=3`

### 4. Swap 알고리즘 (교체)

```java
int temp = answer[i];    // 임시 변수에 첫 번째 값 저장
answer[i] = answer[j];   // 첫 번째 위치에 두 번째 값 대입
answer[j] = temp;        // 두 번째 위치에 임시 변수 값 대입
```

**Swap 과정 시각화:**

```
초기 상태: arr = [0, 1, 2, 3, 4]
query = [1, 3] 처리

1단계: temp = answer[1] = 1
       answer = [0, 1, 2, 3, 4], temp = 1

2단계: answer[1] = answer[3] = 3  
       answer = [0, 3, 2, 3, 4], temp = 1

3단계: answer[3] = temp = 1
       answer = [0, 3, 2, 1, 4]
```

### **실행 예시**

```java
// 입력
arr = [0, 1, 2, 3, 4]
queries = [[0, 3], [1, 2], [1, 4]]

// 처리 과정
초기: [0, 1, 2, 3, 4]

1. [0,3] 처리: [3, 1, 2, 0, 4] (0↔3 교체)
2. [1,2] 처리: [3, 2, 1, 0, 4] (1↔2 교체)  
3. [1,4] 처리: [3, 4, 1, 0, 2] (2↔4 교체)

// 최종 결과: [3, 4, 1, 0, 2]
```

### **핵심 개념 정리**

1. **배열 복사**: 원본 보존을 위한 `Arrays.copyOf()` 사용
2. **Enhanced For문**: 2차원 배열 순회를 위한 간결한 문법
3. **Swap 알고리즘**: 두 값을 교체하는 기본적인 알고리즘 패턴
4. **임시 변수**: 데이터 손실 없이 값을 교체하기 위한 필수 요소

### **다른 접근법**

### XOR을 이용한 Swap (참고용)

```java
// 임시 변수 없이 교체 (정수만 가능)
answer[i] ^= answer[j];
answer[j] ^= answer[i]; 
answer[i] ^= answer[j];
```

하지만 **가독성과 안정성** 면에서 임시 변수를 사용하는 방법이 더 좋습니다.
*/
/*
## 23. 배열에서 조건에 맞는 최솟값 찾기 (Query Range Minimum)

### **문제 설명**

정수 배열 `arr`와 2차원 정수 배열 `queries`이 주어집니다. `queries`의 원소는 각각 하나의 `query`를 나타내며, `[s, e, k]` 꼴입니다.

각 `query`마다 순서대로 `s` ≤ `i` ≤ `e`인 모든 `i`에 대해 `k`보다 크면서 가장 작은 `arr[i]`를 찾습니다.

각 쿼리의 순서에 맞게 답을 저장한 배열을 반환하는 solution 함수를 완성해 주세요.

단, 특정 쿼리의 답이 존재하지 않으면 -1을 저장합니다.

### **내 풀이 (Stream 활용)**
*/
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        return IntStream.range(0, queries.length)
                .map(q -> IntStream.rangeClosed(queries[q][0], queries[q][1])
                        .map(i -> arr[i])
                        .filter(i -> i > queries[q][2])
                        .min().orElse(-1)
                ).toArray();
    }
}
/*
### **🔥 Stream API 완전 분해 분석**

### 1. 외부 스트림: queries 순회

```java
IntStream.range(0, queries.length)
```

- **동작**: 0부터 `queries.length-1`까지의 인덱스 스트림 생성
- **예시**: queries.length가 3이면 → [0, 1, 2] 스트림
- **목적**: 각 쿼리를 순서대로 처리하기 위한 인덱스 제공

### 2. 메인 map 연산

```java
.map(q -> ...)
```

- **q**: 현재 처리 중인 쿼리의 인덱스 (0, 1, 2...)
- **동작**: 각 쿼리 인덱스를 → 해당 쿼리의 결과값으로 변환
- **반환**: 각 쿼리의 답이 담긴 새로운 스트림

### 3. 내부 스트림: 범위 내 원소 순회

```java
IntStream.rangeClosed(queries[q][0], queries[q][1])
```

- **동작**: `queries[q][0]`(시작)부터 `queries[q][1]`(끝)까지의 **포함된** 범위 스트림
- **rangeClosed vs range**:
    - `range(1,4)`: [1, 2, 3] (끝 제외)
    - `rangeClosed(1,4)`: [1, 2, 3, 4] (끝 포함)
- **예시**: `queries[0] = [1, 4, 2]`라면 → [1, 2, 3, 4] 인덱스 스트림

### 4. 인덱스를 배열 값으로 변환

```java
.map(i -> arr[i])
```

- **i**: 범위 내의 각 인덱스 (1, 2, 3, 4...)
- **동작**: 인덱스 → 해당 인덱스의 배열 값으로 변환
- **예시**: arr=[0,1,2,3,4], 인덱스 [1,2,3,4] → 값 [1,2,3,4]

### 5. 조건 필터링

```java
.filter(i -> i > queries[q][2])
```

- **조건**: `i > queries[q][2]` (k보다 큰 값만 선택)
- **동작**: 조건을 만족하는 값들만 남김
- **예시**: k=2, 값[1,2,3,4] → 필터 후 [3,4]

### 6. 최솟값 찾기

```java
.min().orElse(-1)
```

- **`.min()`**: 스트림에서 가장 작은 값을 `OptionalInt`로 반환
- **`.orElse(-1)`**: 값이 없으면 -1 반환, 있으면 해당 값 반환
- **왜 Optional?**: 필터 결과가 비어있을 수 있기 때문

### 7. 배열로 변환

```java
.toArray()
```

- **동작**: 스트림의 모든 결과를 `int[]` 배열로 변환
- **반환**: 각 쿼리의 답이 순서대로 담긴 배열

### **🎯 전체 실행 과정 시뮬레이션**

```java
// 입력 예시
arr = [0, 1, 2, 4, 3]
queries = [[0, 4, 2], [1, 3, 2], [2, 4, 6]]
```

### **Query 0: [0, 4, 2] 처리**

```java
1. rangeClosed(0, 4) → [0, 1, 2, 3, 4] (인덱스)
2. map(i -> arr[i]) → [0, 1, 2, 4, 3] (값)
3. filter(i -> i > 2) → [4, 3] (2보다 큰 값)
4. min() → 3 (최솟값)
5. orElse(-1) → 3 (값이 존재)
```

**결과**: 3

### **Query 1: [1, 3, 2] 처리**

```java
1. rangeClosed(1, 3) → [1, 2, 3] (인덱스)
2. map(i -> arr[i]) → [1, 2, 4] (값)
3. filter(i -> i > 2) → [4] (2보다 큰 값)
4. min() → 4 (최솟값)
5. orElse(-1) → 4 (값이 존재)
```

**결과**: 4

### **Query 2: [2, 4, 6] 처리**

```java
1. rangeClosed(2, 4) → [2, 3, 4] (인덱스)
2. map(i -> arr[i]) → [2, 4, 3] (값)
3. filter(i -> i > 6) → [] (6보다 큰 값 없음)
4. min() → Optional.empty() (비어있음)
5. orElse(-1) → -1 (기본값 반환)
```

**결과**: -1

**최종 답**: [3, 4, -1]

### **💡 Stream API 핵심 개념**

### **1. Stream의 특징**

- **함수형 프로그래밍**: 데이터 변환을 연속된 함수로 표현
- **지연 평가**: 최종 연산(.toArray())이 호출될 때까지 실행되지 않음
- **불변성**: 원본 데이터를 변경하지 않음

### **2. 중간 연산 vs 최종 연산**

```java
// 중간 연산 (Intermediate Operations)
.map()     // 변환
.filter()  // 필터링
.rangeClosed() // 범위 생성

// 최종 연산 (Terminal Operations)
.min()     // 최솟값
.toArray() // 배열 변환
.orElse()  // Optional 처리
```

### **3. Optional 패턴**

```java
// 전통적 방법
if (list.isEmpty()) {
    return -1;
} else {
    return Collections.min(list);
}

// Optional 방법
return [list.stream](http://list.stream)().min().orElse(-1);
```

### **🔄 전통적인 for문과 비교**

### **Stream 버전 (현재 코드)**

```java
return IntStream.range(0, queries.length)
    .map(q -> IntStream.rangeClosed(queries[q][0], queries[q][1])
        .map(i -> arr[i])
        .filter(i -> i > queries[q][2])
        .min().orElse(-1)
    ).toArray();
```

### **전통적 for문 버전**

```java
int[] answer = new int[queries.length];

for (int q = 0; q < queries.length; q++) {
    int start = queries[q][0];
    int end = queries[q][1];
    int k = queries[q][2];
    
    int minValue = Integer.MAX_VALUE;
    boolean found = false;
    
    for (int i = start; i <= end; i++) {
        if (arr[i] > k) {
            minValue = Math.min(minValue, arr[i]);
            found = true;
        }
    }
    
    answer[q] = found ? minValue : -1;
}

return answer;
```

### **📊 두 방법의 장단점**

| 구분 | Stream API | 전통적 for문 |
| --- | --- | --- |
| **가독성** | 높음 (선언적) | 보통 (명령적) |
| **간결성** | 매우 높음 | 보통 |
| **성능** | 약간 느림 | 빠름 |
| **디버깅** | 어려움 | 쉬움 |
| **학습 곡선** | 높음 | 낮음 |

### **🎓 Stream 학습 팁**

1. **단계별 분해**: 복잡한 Stream을 작은 단위로 나누어 이해
2. **중간 출력**: `.peek(System.out::println)`으로 중간 결과 확인
3. **Optional 이해**: null 대신 Optional 사용하는 이유 파악
4. **함수형 사고**: 데이터 변환의 파이프라인으로 생각

이 문제는 **Stream API의 고급 활용법**을 보여주는 좋은 예시입니다!

*/