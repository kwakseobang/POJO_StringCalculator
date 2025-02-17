# 🦁 멋쟁이 사자처럼 13기 JAVA 스터디 1주차 과제 

## ✅ 주제
- 문자열 계산기 (POJO/ JAVA만 사용해서 문제 풀이)

## 📌 기능 요구 사항
- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행하는 계산기 구현
- 입력 문자열의 숫자와 사칙 연산 기호 사이에는 공백이 포함되어야 한다.
- 숫자는 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달 할 경우 구분자를 기준으로 분리한 각 숫자와, 마지 막에 하나의 공백을 가지고 전달된 연산자의 계산 결과를 반환. (아래 입출력예시 참고)
- 연산자의 경우 하나만 입력 받는다.
- 사칙 연산만 포함한다.
- 소숫점의 경우 0.1, 0.2 와 같이 소숫점 첫째짜리까지 표시
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생 시킨다.

## 📌 프로그래밍 요구 사항
- 각 메소드는 하나의 일만 진행한다
- 입력 값이 빈 문자열이거나, null인경우 IllegalArgumentException을 발생하고, 어떤 예외인지 알 수 있도록 에러 메시지 포함
- 사칙연산 기호가 아닌경우 IllegalArgumentException을 발생하고, 에러 메시지 포함
- 그 외 다양한 예외 케이스에 대해서는 본인이 생각해서 구현진행
- 각 메소드의 depth는 2 depth 까지만 허용

## 🧮 입력 및 출력 예시
~~~ java
// <=== 입력 ===>
 1:2,3:4 +
 6:10,2:3 *
 7,2:3 -
 4:2,5 /
// <=== 출력 ===>
1. 1 + 2 + 3 + 4 = 10
2. 6 * 10 * 2 * 3 = 360
3. 7 - 2 - 3 = 2
4. 4 / 2 / 5 = 0.4
~~~

## 구현 로직
1. 사용자가 입력을 한다.
2. 피연산자, 연산자, 구분자 등 입력 값에 대해 유효성 검증을 한다.
3. 유효성 검증이 완료되면 피연산자를 구분자를 기준으로 파싱하여 저장한다.
4. 편한 연산을 위해 Queue로 변환 후 계산한다.
5. 수식과 결과 값을 출력 버퍼에 저장한다.
6. 종료 시 버퍼에 있는 출력 값들을 출력한다.

## 에외처리 
- IllegalArgumentException
  - 피연산자를 잘못 입력한 케이스
  - 연산자를 잘못 입력한 케이스
- NoSuchElementException
  - 입력 시 공백을 기준으로 피연산자만을 입력하거나 연산자만을 입력하거나 빈 값일 떄 등 다양한 케이스
- NullPointerException
  - 유효성 검사 시 ExpressionData가 Null 인 케이스
  - Queue로 변환 후 오류로 인해 값이 Null 인 케이스
- ExitException
  - 사용자가 종료 버튼(q)을 눌렀을 떄 발생 
- ArithmeticException
  - 0으로 나눈 케이스  

## 🤝 Git Convention

### Branch
- `main` : 개발용 branch
- feature : 기능 구현용 branch
- Issue_종류/#Issue_번호 : branch 생성


### Commit Prefix

| 종류        | 내용                                             |
|-----------| ------------------------------------------------ |
| 💫 Feat        | 기능 구현                                          |
| 🐛 Fix    | 버그 수정                                           |
| 🔨 Refactor | 코드 리팩토링                                         |
| ✅ Test    | 테스트 업무                                        |
| 🗂️  File   | 파일 이동 또는 삭제, 파일명 변경                         |
| 📝 Docs   | md, yml 등의 문서 작업                               |
| 🔧 Chore  | 이외의 애매하거나 자잘한 수정                            |
| ⚙️ Setting | 빌드,패키지,인프라 등 프로젝트 설정                           |
