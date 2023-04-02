# HighTech Case Study

## Movie List Feature Specs

## BDD Specs

### Story: User requests to see now playing movies

### Narrative

```
As an online user
I want the app to automatically load now playing movies
So I can always enjoy the newest load now playing movies
```

#### Scenarios (Acceptance criteria)

```
Given the user has connectivity
When the user requests to see now playing movies
Then the app should display the latest now playing movies from remote
```

## Use Cases

### Load Crypto Toplist From Remote Use Case

#### Data:
- URL

#### Primary course (happy path):
1. Execute "Load Crypto Toplist" command with above data.
2. System downloads data from the URL.
3. System validates downloaded data.
4. System creates crypto toplist from valid data.
5. System delivers crypto toplist.

#### Invalid data – error course (sad path):
1. System delivers invalid data error.

#### No connectivity – error course (sad path):
1. System delivers connectivity error.

---

## Flowchart
TBD

---

## App Architecture
TBD

## Model Specs

### Crypto Toplist

| Property      | Type          |
|---------------|---------------|
| `TBD`         | `TBD`         |
| `TBD` 	| `TBD`    	|

### Payload contract

```
GET /toplist

200 RESPONSE

{
	"items": []
}
```