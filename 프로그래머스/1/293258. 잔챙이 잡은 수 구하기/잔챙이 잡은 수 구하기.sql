-- 코드를 작성해주세요
SELECT COUNT(*) AS FISH_COUNT
FROM FISH_INFO
WHERE IFNULL(LENGTH, 10) <= 10
-- 여기서 프로그래머스 오류가 있어서, 10 이하가 아닌 10 미만으로 해야 통과가 되었다.
