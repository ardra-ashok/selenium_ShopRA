
Feature: Daily environment health checks via database queries

@DBHealthCheck.s2
Scenario Outline: check return code of daily jobs [<env>]
This scenario will verify that all the daily jobs have a returned 1 as RETURNCODE:

Given I set the test environment to "<env>"
And I get the current date with format "dd/MMM/yyy" and save as "$TODAY$"

When I run a DB query with the following and save the result in variable "$JOBS_STATUS$"
    |  OPERATOR       | OPERAND                                             |
    |  SELECT         | a.jobnumber, a.description, a.outputfile            |
    |  SELECT         | b.actualstarttime, b.actualfinishtime               |
    |  SELECT         | b.returncode AS return_code , b.masterschedulenumber|
    |  FROM           | odr_superjob a , odr_schedulerhistory b             |
    |  WHERE          | trunc(b.actualstarttime) >= '$TODAY$'               |
    |  AND            | a.jobnumber = b.jobnumber                           |
Then I assert the query results saved in variable "$JOBS_STATUS$" with following
    |Field          | Operator  | Value     |
    |return_code    | =         | 1         |

  Examples:
    | env       |
    | CUBIC-ITF |
