# 항해플러스 백앤드 4기 W3: e-Commerce


1. Milestone
- 3/30(토)
  - milestone 작성
  - 요구사항 분석 및 API명세서 작성
- 4/1(월)
  - 시퀀스 다이어그램, ERD 작성
- 4/2(화)
  - DB연결 
  - 잔액충전/조회API 개발
- 4/3(수)
  - 주문/결제API 개발
  - 상품조회API 개발
- 4/4(목)
  - 상위 상품 조회API 개발



2. API 명세

잔액조회
- GET) wallet/{id}
- request
  - parameter) id: long 필수값
- response
  - 200: 성공시 User(유저정보 객체) 반환
  - 400: 실패 시 null 반환
- Error
  - id가 유실된 경우

잔액충전
- POST) wallet/{id}
- request
  - parameter) id: long 필수값
  - body) amount: int default
- response
  - 200: 성공시 User(유저정보 객체)  반환
  - 400: 실패 시 null 반환
- Error
  - id가 유실된 경우
  - 충전금액이 5000원 미만인 경우

상품 조회
- GET) product/{id}
- request
  - parameter) id: long
- response
  - 200: 성공시 Product(상품 객체) 반환
  - 400: 실패 시 null 반환

주문/결제
- POST) order/{userId}/{productId}
- request
  - parameter) userId: long 필수값, productId: long 필수값
- response
  - 200: 성공시 Order(주문 객체) 반환
  - 400: 실패 시 null 반환
- Error
  - userId가 유실된 경우,
  - 상품이 품절된 경우
  - 잔액이 부족한 경우

상위 상품 목록 조회
- GET) products/top
- request
  - body) topNum: long, soldOutYn: String
- response
  - 200: 성공시 List<Product>(상품 객체 리스트) 반환
  - 400: 실패 시 null 반환



3. 시퀀스 다이어그램

![잔액조회.png](Img%2F%EC%9E%94%EC%95%A1%EC%A1%B0%ED%9A%8C.png)

![잔액충전.png](Img%2F%EC%9E%94%EC%95%A1%EC%B6%A9%EC%A0%84.png)

![상품조회.png](Img%2F%EC%83%81%ED%92%88%EC%A1%B0%ED%9A%8C.png)

![주문.png](Img%2F%EC%A3%BC%EB%AC%B8.png)

![상위 상품 조회.png](Img%2F%EC%83%81%EC%9C%84%20%EC%83%81%ED%92%88%20%EC%A1%B0%ED%9A%8C.png)



4. ERD

![drawSQL-image-export.png](Img%2FdrawSQL-image-export.png)


