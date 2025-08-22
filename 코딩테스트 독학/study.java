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

