-- 코드를 입력하세요
SELECT REST_INFO.REST_ID AS REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, ROUND(AVG(REVIEW_SCORE), 2) AS SCORE
FROM REST_INFO INNER JOIN REST_REVIEW
ON REST_INFO.REST_ID = REST_REVIEW.REST_ID
GROUP BY REST_INFO.REST_ID
HAVING ADDRESS LIKE "서울%"
ORDER BY SCORE DESC, FAVORITES DESC;
