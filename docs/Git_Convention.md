## **Git Flow전략 사용**

![Untitled.png](..%2F..%2FDownloads%2FUntitled.png)

## **Git Branch Convention**

1. 작업단위/작업뷰위치_작업내용 으로 통일

- 작업내용은 2가지로 통일(view, inflate)
- ex. feature/home-view
- ex. feature/main-inflate


2. default branch는 develop

-> develop(default) 브랜치에서 본인 브랜치 생성  
-> add-commit-pull-push-merge  
-> 작업시작할때 pull 받고 시작하는거 잊지않기
-> 머지할 때 항상 노티주기

## **Git Commit Message Convention**

### - **Issue Number**

- 솝커톤 내에서 사용하지 않기로 함

### - **Base Structure**

```
feat : 작업내용
```

### - **TYPE**

- feat: 새로운 기능 개발
- refactor: 코드 수정
- chore: 기초세팅 및 프로그램 세팅
- docs : 문서 작업
