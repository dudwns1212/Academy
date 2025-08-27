use newhr;

select concat('haha' , 'good!') 좋아;
select first_name, concat(first_name,' ', last_name) from employees;
select substr(first_name, 3)
	, substr(first_name, 3, 5)
from employees;

select round(123.456)
	, round(123.456, 2)
    , round(123.456, -2)
    , truncate(123.456,0)
;

# 1380
select salary, round(salary*1380, -4)
from employees;

select now(), sysdate(), curdate(), curtime();

select adddate(curdate(), interval 137 day)
	, year(curdate())
    , month(curdate())
;

# 입사 후 20주년 일자.
select hire_date, last_name, adddate(hire_date, interval 20 year) 입사후20주년일자
from employees;

select round(datediff(curdate(), hire_date) /  365.5,2) '입사 후 근속년수'
	, timestampdiff(year, hire_date, curdate())
from employees;

select last_name, hire_date
	, date_format(hire_date, '%Y-%m-%d') 입사연월일
from employees;

/* 
  2000년1월1일 이후 입사자입니다.

- 연봉은 커미션을 반영한 급여의 12배입니다. o
- 연봉은 원화로 표시합니다.(환율 : 1389) o
- 연봉은 천원 단위로 반올림합니다. o
- 연봉은 천원 단위로 콤마를 부여합니다.
- 근속년수는 소수2째자리까지 표시합니다. o
- 성명은 성과 명을 합하여 출력합니다. 각 첫글자를 대문자로 합니다.
*/

select concat(first_name,' ', last_name) 성명, format(round(salary*(1+ifnull(commission_pct,0))*12*1389,-3),0) 연봉
	, round(datediff(curdate(), hire_date) / 365.5,2) 근속년수
from employees   
where hire_date > '2000-01-01'
;

select last_name, job_id,
	case job_id when 'IT_PROG' then salary * 2
		when 'ST_CLERK' then salary * 1.5
		else salary
	end bonus
from employees;

# 부서번호가 10이면 급여의 1.2배, 20이면 급여의 2배, 나머지 급여 그대로
select department_id, salary,
	case when department_id = 10 then salary * 1.2
		when department_id = 20 then salary * 2
        else salary
    end bonus
from employees;

/*
급여의 등급을 함께 출력하시오.
부서번호, 성명, 급여, 급여등급
5000이하이면 C,
10000이하이면 B, 
15000이하이면 A,
15000을 초과하면 S
*/
select department_id 부서번호, concat(first_name, ' ', last_name) 성명, salary 급여, salary,
	case when salary <= 5000 then 'C'
		when salary <=10000 then 'B'
        when salary <=15000 then 'A'
        when salary > 15000 then 'S'
        else salary
    end 급여등급
from employees;

# 성, 명, 급여, 근무부서명 -> employees와 department 테이블을 조인해야함
select e.last_name, d.department_name
from employees e, departments d
where e.department_id = d.department_id
;

select * from employees;
# 스티븐 킹- 90번에 근무, 부서번호 90번에 해당하는 부서정보는?
select *
from departments
where department_id = 90;

select *
from employees e, departments d
where e.department_id = d.department_id
;

select *
from employees e join departments d
	on e.department_id = d.department_id
;

select *
from employees e join departments d
	using(department_id)
;

/* 1. 20번 부서의 이름과 그 부서에 근무하는 사원의 이름을 출력하시오. 단, 급여로 오름차순 정렬하시오.

2. 1400,1500 번 위치의 도시 이름과 그곳에 있는 부서의 이름을 출력하시오.

3. IT_PROG가 직무인 직원들의 다음 정보를 출력.
   - 입사일자를 일/월/년으로 출력
   - 부서명, 도시명도 출력합니다.
   */
# 1.
select department_name 부서이름, concat(first_name, ' ' ,last_name) 사원이름
from employees e join departments d
	using(department_id)
where department_id = 20
order by salary;

# 2. 
select department_name 부서이름, city 도시이름
from departments d join countries c join locations l
where d.location_id = l.location_id and l.country_id = c.country_id
	and l.location_id in ('1400','1500');

#3.
select department_name 부서명, city 도시명, date_format(hire_date, '%d-%m-%Y') 입사일자
from employees e join departments d join locations l
where (e.department_id = d.department_id) and (l.location_id = d.location_id)
	and job_id = 'IT_PROG';
    
select e.last_name, d.department_name
from employees e join departments d on e.department_id = d.department_id;

select count(*) -- 106, left조인(outer join)으로 널값도 join되게 함으로 값이 107로 바뀜
from employees e left join departments d on e.department_id = d.department_id
;

select count(*) -- 107
from employees e
;

# department_id가 널인 경우 => 아직 부서에 배치되지 않은 사원
use newhr;
select * 
from employees 
where department_id is null
;

# Seattle에 근무하는 직원들의 성명과 급여, 입사일자, 부서명을 출력하시오 .
select concat(first_name, ' ', last_name) 성명, salary 급여, hire_date 입사일자, department_name 부서명
from employees e join departments d join locations l
where e.department_id = d.department_id 
	and d.location_id = l.location_id
	and city = 'Seattle'
;

select concat(e.last_name, ' ', e.first_name) as 성명
	, e.salary as 급여 , e.hire_date as 입사일자, d.department_name as 부서명
from employees e
	join departments d on e.department_id = d.department_id
    join locations l on d.location_id = l.location_id
where l.city = 'Seattle';

# 사번 , 성명 , 급여 , 입사일자 , 관리자사번, 관리자성명을 출력
select e.employee_id 사번, e.last_name 성명, e.salary 급여, e.hire_date 입사일자, m.employee_id 관리자사번, m.last_name 관리자성명
from employees e 
	join employees m on e.manager_id = m.employee_id
;
/*
1. 사번, 성명, 급여, 입사일자, 관리자사번, 관리자명, 입사일자를 출력합니다.
  - 관리자가 존재하지 않는 경우 관리자없음을 출력합니다.

2. 부서번호, 부서명, 부서장사번, 부서장명을 출력합니다.
  - 부서장이 없으면 부서장사번, 부서장명을 부서장없음이라고 출력합니다.
*/
select e.employee_id 사번, e.last_name 성명, e.salary 급여, e.hire_date 입사일자, ifnull(m.employee_id, '관리자없음') 관리자사번, ifnull(m.last_name, '관리자없음') 관리자명
from employees e 
	left join employees m on e.manager_id = m.employee_id;
    
select d.department_id 부서번호, d.department_name 부서명, ifnull(d.manager_id, '부서장없음') 부서장사번, ifnull(e.last_name, '부서장없음') 부서장이름
from departments d 
    left join employees e on e.manager_id = d.manager_id
;

select min(salary)
from employees;

select max(salary), sum(salary), avg(salary), min(salary)
from employees;

select d.department_id, avg(salary), d.department_name
from employees e
	left join departments d on e.department_id = d.department_id
group by department_id
order by department_id;
	
select department_id, avg(salary)
from employees 

# where avg(salary) >= 10000

group by department_id
having avg(salary) >= 10000;

/*
부서별로 평균급여를 출력합니다.
단, 부서명과 부서위치도시명도 출력합니다. o
- 짝수년도에 입사한 직원만 평균합니다. 
- 평균급여가 7000이상만 출력합니다. o
- 평균급여는 천단위 이하를 버립니다. o
- 평균급여가 많은 순서로 정렬합니다. o
*/
select truncate(avg(salary),-3) '부서별 평균급여', department_name 부서명, city 도시명
from employees e 
	join departments d on d.department_id = e.department_id
    join locations l on d.location_id = l.location_id
where date_format(hire_date, '%Y') %2 = 0
group by e.department_id
having avg(salary) >= 7000
order by avg(salary) desc
;

# Neena가 근무하는 부서의 부서원 정보를 출력
select department_id
from employees
where first_name = 'Neena';

select * 
from employees
where department_id = 90;

select * 
from employees
where department_id = (select department_id
						from employees
						where first_name = 'Neena');

# Steven이 근무하는 부서원
select * 
from employees
where department_id in (select department_id
						from employees
						where first_name = 'Steven');
                        
# multi column
-- 부서별로 최고급여를 받는 사원을 조회
select max(salary)
from employees
group by department_id
;

select department_id, last_name, salary
from employees 
where (department_id, salary) in (select department_id, max(salary)
				from employees
				group by department_id)
order by department_id;

# 자신의 부서평균 급여보다 많은 급여를 받는 직원을 조회
select last_name, salary, department_id
from employees e
where salary > (select avg(salary) from employees
				where department_id = e.department_id);

select department_id, avg(salary) avg_salary
from employees
group by department_id;

select e.last_name, e.salary, e.department_id
from employees e join (select department_id, avg(salary) avg_salary
						from employees
						group by department_id) das 
	on e.department_id = das.department_id
where e.salary > das.avg_salary;

# Seattle에서 근무하는 직원의 성명 급여 입사일자 부서명
select concat(first_name, ' ', last_name) 성명, salary 급여, hire_date 입사일자, department_name 부서명
from employees e join departments d join locations l
where e.department_id = d.department_id 
	and d.location_id = l.location_id
	and city = 'Seattle'
;


# 서브쿼리 -> 시애틀에서 근무하는 직원
select concat(first_name, ' ', last_name) 성명, salary 급여, hire_date 입사일자
from employees e
where department_id in (select department_id 
						from departments d 
                        where d.location_id in (select location_id 
												from locations
                                                where city = 'Seattle'));

select * 
from employees
order by salary desc
limit 3;

select last_name, salary 
	, rank() over(order by salary desc) sal_rank
from employees;

select last_name, salary,
	case when salary <= 5000 then 'C'
			when salary <= 10000 then 'B'
            when salary <= 15000 then 'A'
            when salary >15000	then 'S'
    else salary
    end sal_grade
from employees
;

select case when salary <= 5000 then 'C'
			when salary <= 10000 then 'B'
            when salary <= 15000 then 'A'
    else 'S'
    end sal_grade, count(*) cnt
from employees
group by (case when salary <= 5000 then 'C'
			when salary <= 10000 then 'B'
            when salary <= 15000 then 'A'
    else 'S'
    end )
order by (case sal_grade when 'S' then 1
			when 'A' then 2
            when 'B' then 3
            else '4' end)
;

select * from employees where salary > 15000;
/*
근속년수에 따른 인원수를 출력합니다.
10년이하, 15년이하, 20년이하, 20년 초과 인원수를 출력합니다.
*/
select case when round(datediff(curdate(),hire_date)/365,1) <= 10 then 'C'
			when round(datediff(curdate(),hire_date)/365,1) <= 15 then 'B'
            when round(datediff(curdate(),hire_date)/365,1) <= 20 then 'A'
            else 'S'
            end grade, count(*) cnt
from employees
group by (case when round(datediff(curdate(),hire_date)/365,1) <= 10 then 'C'
			when round(datediff(curdate(),hire_date)/365,1) <= 15 then 'B'
            when round(datediff(curdate(),hire_date)/365,1) <= 20 then 'A'
            else 'S'
            end )
;

select timestampdiff(year, hire_date, curdate()) from employees;  
select round(datediff(curdate(),hire_date)/365,0) from employees;

# 부서번호로 부서원 정보 조회
select * from employees where department_id = 120;
select * from employees where year(hire_date) = 2013;

select * from employees where job_id = 'IT_PROG';
select employee_id, last_name, salary from employees e where e.department_id in
					(select d.department_id from departments d where d.location_id in
					(select l.location_id from locations l where city = 'Seattle'));
select * from employees e where e.department_id in (select d.department_id from departments d where d.location_id in(select l.location_id from locations l where l.country_id in (select c.country_id from countries c))) ;
select e.*, c.country_name from employees e join departments d on e.department_id = d.department_id join locations l on d.location_id = l.location_id join countries c on l.country_id = c.country_id;

select * from employees;

select j.job_id as id, j.job_title as name,format(round(sum(e.salary * (1 + coalesce(e.commission_pct,0)) * 12 * 1390),-3),0) as sum, format(round(avg(e.salary * (1 + coalesce(e.commission_pct, 0)) * 12 * 1390),-3),0) as avg, format(round(max(e.salary * (1 + coalesce(e.commission_pct, 0)) * 12 * 1390),-3),0) as max, format(round(min(e.salary * (1 + coalesce(e.commission_pct, 0)) * 12 * 1390),-3),0) as min, count(*) as count from employees e join jobs j on e.job_id = j.job_id group by j.job_id order by j.job_id;
select * from employees;