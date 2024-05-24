# Q1. 숫자관련 함수 사용
-- 2의 3제곱
SELECT pow(2, 3) AS "2**3"
FROM dual;

-- 8 나누기 3의 나머지
SELECT mod(8, 3) AS "8%3";

-- 최대값, 최솟값
SELECT greatest(15,34,1230,15,26,123123123,37), least(15,34,1230,15,26,123123123,37);

-- 반올림
SELECT round(3.14159), round(3.14159, 0), round(3.14159, 1), round(3.14159, 2), round(3.14159, 3), round(3.14159, 10);

# Q2. 문자 관련 함수
-- 아스키 코드값 얻기
SELECT ascii('0'), ascii('A'), ascii('a');

-- concat 메서드를 써보자.
SELECT concat('president의 이름은 ', ename, ' 입니다.') AS '소개'
FROM emp
WHERE job = 'PRESIDENT';

-- 이름의 길이가 5인 직원의 이름을 조회
SELECT ename
FROM emp
WHERE length(ename) = 5;

SELECT length('김싸피'), char_length('김싸피');
SELECT length('😎'), char_length('😉');

-- 문자열 변경
SELECT replace('Hello abc abc', 'abc', 'ssafy');

-- 문자열 인덱스
SELECT instr('Hello SSAFY', 'SSAFY');

-- 모든 직원의 이름 3자리조회
SELECT substr(ename, 1, 3)
FROM emp;

-- LPAD RPAD
SELECT LPAD('SSAFY',10,'*'), RPAD('SSAFY',10,'*');

-- REVERSE
SELECT REVERSE('HELLO SSAFY!');
SELECT REVERSE('우영우역삼역기러기인도인토마토별똥별스위스');

# Q3. 날짜 관련함수

-- 2초 더하기
SELECT addtime("2022-02-13 17:29:21", "2");

-- 날짜차이
SELECT datediff("2008-02-18", "2006-02-21");

-- 오늘은?
SELECT now(), day(now()), month(now()), year(now()), yearweek(now());


# Q4. 트랜잭셕 사용해보기
SET autocommit = 0;

USE ssafy;
CREATE TABLE test_table(val VARCHAR(20));

-- 롤백
START TRANSACTION;
INSERT INTO test_table VALUE('A');
INSERT INTO test_table VALUE('B');
INSERT INTO test_table VALUE('C');
INSERT INTO test_table VALUE('D');

ROLLBACK;
SELECT * FROM test_table;

-- 커밋
START TRANSACTION;
INSERT INTO test_table VALUE('S');
INSERT INTO test_table VALUE('S');
INSERT INTO test_table VALUE('A');
INSERT INTO test_table VALUE('F');
INSERT INTO test_table VALUE('Y');

COMMIT;
SELECT * FROM test_table;







