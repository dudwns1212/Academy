use newhr;

select * from employees;

# 과제1 복습
select employee_id 사번, concat(first_name, ' ', last_name) 성명, salary 급여, hire_date 입사일자, email 이메일주소
from employees
where salary >= 10000
	and commission_pct != null
    and department_id in (80,100)
    and manager_id != null
    and job_id like 'P%'
order by hire_date; 

# 과제2 복습
select concat(first_name,' ', last_name) 성명, format(round(salary*(1+ifnull(commission_pct,0))*12*1389,-3),0) 연봉
    , round(datediff(curdate(), hire_date) / 365.5,2) 근속년수
from employees  
where hire_date > '2000-01-01'
;
select concat(first_name, ' ', last_name) 성명, round(datediff(curdate(), hire_date),2) 근속년수, 
	format(round((salary * (1 + ifnull(commission_pct,0)) * 12 * 1389),-3),0) 연봉
from employees
where hire_date > '2000-01-01'
;

# 과제3 복습
select department_id 부서번호, concat(first_name, ' ', last_name) 성명, salary 급여, salary,
	 case when salary <= 5000 then 'C'
		when salary <= 10000 then 'B'
        when salary <= 15000 then 'A'
        when salary > 15000 then 'S'
        else salary
     end 급여등급
from employees;

# 과제4 복습
select department_name 부서명, concat(first_name, ' ', last_name) 성명 
from employees e join departments d
	using(department_id)
where department_id = 20
order by salary
;
select city 도시명, department_name 부서명
from departments d join locations l
	where d.location_id = l.location_id
	and d.location_id in (1400,1500)
;
select date_format(hire_date, '%d-%M-%Y') 입사일자, city 도시명, department_name 부서명 
from employees e join departments d join locations l
where e.department_id = d.department_id 
	and d.location_id = l.location_id
	and job_id = 'IT_PROG';

# 7/15
# 과제 1 복습
select employee_id 사번, concat(first_name, ' ', last_name) 성명, salary 급여, hire_date 입사일자, email 이메일주소
from employees
where salary >= 10000 
	and commission_pct is not null
    and department_id in (80,100)
    and manager_id is not null
    and job_id like 'P%'
order by hire_date;
# 과제 2 복습
select concat(first_name, ' ', last_name) 성명, format(round(salary*(1+ifnull(commission_pct,0))*12*1389,-3),0) 연봉, 
	round(datediff(curdate(),hire_date)/365.5,2) 근속년수
from employees
where hire_date > '2000-01-01'
;
# 과제 3 복습
select salary 급여, department_id 부서번호, concat(first_name, ' ', last_name) 성명,
	case when salary <= 5000 then 'C'
		when salary <= 10000 then 'B'
        when salary <=15000 then 'A'
        when salary > 15000 then 'S'
    else salary
    end 급여등급
from employees;

# 과제 4 복습
select department_name 부서이름, concat(first_name, ' ', last_name) 성명
from employees e join departments d
	using(department_id)
where d.department_id = 20
order by salary
;
select city 도시, department_name 부서이름
from locations l join departments d  
	using(location_id)
where d.location_id in (1400,1500)
;
select date_format(hire_date, '%d-%m-%Y') 입사일자, department_name 부서명, city 도시명
from employees e join departments d join locations l 
where e.department_id = d.department_id
	and l.location_id = d.location_id
	and job_id = 'IT_PROG'
;
# 과제 5 복습
select e.employee_id 사번, e.last_name 성명, e.salary 급여, e.hire_date 입사일자, ifnull(m.employee_id,'관리자없음') 관리자사번, 
ifnull(m.last_name, '관리자없음') 관리자명
from employees e left join employees m
	on e.manager_id = m.employee_id
#where e.manager_id = m.employee_id   left조인은 무조건 on을 써야함
;
# 과제 6 복습
select truncate(avg(salary),3) 평균급여, department_name 부서명, city 도시명
from employees e join departments d join locations l
where e.department_id = d.department_id 
	and d.location_id = l.location_id
    and year(hire_date) % 2 = 0
group by d.department_id
having avg(salary) >= 7000
order by avg(salary) desc;
# 과제 7 복습
select concat(e.last_name, ' ', e.first_name) 성명
    , e.salary 급여 , e.hire_date 입사일자
from employees e
where e.department_id in (select d.department_id 
						from departments d
                        where d.location_id in (select l.location_id 
												from locations l
                                                where city = 'Seattle'));