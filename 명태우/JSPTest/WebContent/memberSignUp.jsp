<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Member SignUp</title>
    </head>
    <body>
        <form action="mSignUp" method="post">
            회원 가입</br>
            이름 : <input type="text" name="txtName"></br>
            암호 : <input type="password" name="txtPassWord"></br>
            성별 : <input type="radio" name="rdoGender" value="M" checked="checked">남 
                   <input type="radio" name="rdoGender" value="W">여</br>
            취미 : <input type="checkbox" name="ckbHobby" value="sport">운동 
                   <input type="checkbox" name="ckbHobby" value="cooking">요리 
                   <input type="checkbox" name="ckbHobby" value="reading">독서 
                   <input type="checkbox" name="ckbHobby" value="travel">여행</br>
            거주지 : <select name="selResidence">
                        <option value="Seoul" selected="selected">서울</option>
                        <option value="Gyeonggi" >경기</option>
                        <option value="Gangwon" >강원</option>
                        <option value="Chungcheong" >충청</option>
                        <option value="Jeonra" >전라</option>
                        <option value="Gyeongsang" >경상</option>
                        <option value="Jeju" >제주</option>
                     </select></br>
            <input type="submit" value="가입">
        </form>
    </body>
</html>