# Write your MySQL query statement below

# ^ -> string yhi se start honi chahiye
# [A-Za-z] first character inme se hona chahiye
# [A-Za-z0-9_.-] next kitne bhi character inme se ho skte h
# * -> iska mtlb upr vale connected h ki upr vala zero times ya zero se jyada times bhi ho skta h
# @leetcode -> this must be present.
# \\. -> regex isko '\.' ese read krta h mtlb . ko represent krne ke lie.
# com -> normal text
# $ -> iske baad kuch nhi aana chahiye.
# 'c' -> case sensitive ke lie.

select * from Users
where REGEXP_LIKE(
    mail,
    '^[A-Za-z][A-Za-z0-9_.-]*@leetcode\\.com$',
    'c'
) 