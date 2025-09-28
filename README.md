# EHL Stats Backend
This project provides a basic backend system for collecting, storing, and managing player statistics from the Norwegian top division of hockey (EHL).

The system has three main parts:
1. **Web Scraper (Python):** Scrapes player statistics from a target website and exports the data as a `.csv` file.
2. **Database Integration:** Imports the `.csv` file into a **PostgresSQL** database table.
3. **Spring Boot Application (Java):** Provides a REST API with full **CRUD** (Create, read, update, delete) functionality for managing the player data.

---

### Features  
* Automated scraping of player statistics (Python).
* Data export as `.csv` for portability and reuse.
* Structured storage in **Postgres**.
* REST API built with **Spring Boot** for database interaction.
* Full CRUD support for player statistics.

---

### Tech Stack  
* **Python** (web scraping & CSV export)
* **PostgresSQL** (database)
* **Java (Spring Boot)** (backend REST API)

---

### Setup & Installation
#### 1. Clone the Repository
```bash
git clone https://github.com/olaosterlie/EHLWebsite.git
cd EHLWebsite
```
#### 2. Python Scraper
* Launch Jupyter:
```bash
jupyter notebook
```
* Open `scraper.ipynb` in the Jupyter interface.
* Run all cells to scrape the website and export the player statistics.
* Output:
```stats.csv```
(contains player stats)
#### 3. Database Setup (Postgres)
* Create a database:
```sql
CREATE DATABASE ehl_stats;
```
* Create a table:
```sql
CREATE TABLE player_data (
    player_name VARCHAR(100),
    pos VARCHAR(100),
    team VARCHAR(100),
    gp INTEGER,
    g INTEGER,
    a INTEGER,
    p INTEGER,
    pim INTEGER,
    nation VARCHAR(100)
);
```
* Import CSV into the table:
```sql
COPY player_data (player_name, pos, team, gp, g, a, p, pim, nation) FROM 'stats.csv' DELIMITER ',' CSV HEADER;
```
(players.csv must be the file path for the csv file)
#### 4. Spring Boot Application
* Run the application:
```bash
.\mvnw spring-boot:run
```
(or use IDE (probably preferred)

---
### API Endpoints
|Method|Endpoint|Description|
|------|--------|-----------|
|GET|`/players`|Get all players|
|GET|`/players?name={name}|Get players if name contains NAME|
|GET|`/players?position={position}|Get players if position contains POSITION|
|GET|`/players?nation={nation}|Get players if nation contains NATION|
|GET|`/players?position={team}|Get players if team contains TEAM|

---
### Future Improvements
* GET methods for rankings for stats.
* Automate scraper runs with a scheduler.
* Dockerize the full stack for easier deployment.
* Add authentication & role-based access to the API.
* Build a simple frontend dashboard for visualization.
