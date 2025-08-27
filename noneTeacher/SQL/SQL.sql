use newhr;
select * from employees;
# 부서번호 100번에 근무하는 직원들의 이름을 출력하시오.
select first_name 성 
from employees 
where department_id = 100
;
select distinct department_id
from employees
;
select last_name, salary, (salary+200) * 12 급여
from employees
;
select last_name, commission_pct
, salary * (1 + ifnull(commission_pct, 0)) * 12 "커미션반영급여"
from employees
;
# 성이 King인 직원 조회
select *
from employees
where salary > 10000 and hire_date >= '2010-01-01';

select employee_id 사원, first_name 성명, salary 급여, hire_date 입사일자, email 이메일
from employees
where salary >= 10000 
and commission_pct is not null   
and department_id in (80, 100)
and manager_id is not null
and job_id like 'P%'
order by hire_date;

select count(*) 
from employees
where job_id = 'IT_PROG'
and department_id = 100
or first_name like 'D%'
;