SELECT Person.FirstName, Person.LastName, Address.City, Address.State  FROM Person LEFT JOIN Address ON (Person.PersonId =
 Address .PersonId);
 -- noinspection SqlDialectInspection
SELECT T1.Score,
 CASE
     WHEN @rowtotal = T1.Score THEN
     @rownum
     WHEN @rowtotal := T1.Score THEN
     @rownum := @rownum + 1
     WHEN @rowtotal = 0 THEN
     @rownum := @rownum + 1
     END AS Rank FROM (SELECT * FROM Scores ORDER BY Score DESC ) AS T1, (SELECT @rownum := 0 ,@rowtotal := NULL) r
SELECT T2.Num FROM (
SELECT Logs.Num,
CASE
 WHEN @rowtotal := Logs.Num THEN
 @rownum := 1
 WHEN @rowtotal = Logs.Num THEN
 @rownum = @rownum + 1
 END AS numtimes FROM Logs,
(SELECT @rownum := 0 ,@rowtotal := NULL) r) T2 WHERE T2.numtimes >= 3