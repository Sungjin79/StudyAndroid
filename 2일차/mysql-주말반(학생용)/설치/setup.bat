@echo off
cls
"C:\Program Files (x86)\MySQL\MySQL Server 5.6\bin\mysql.exe" -uroot -p --default-character-set=utf8 < myschool.sql
echo 처리가 완료되었습니다.
pause