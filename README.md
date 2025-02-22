# Currency-Converter-API-Integration
# Currency Converter API (Spring Boot)

## 📌 Project Overview

This project is a **Spring Boot** application that integrates with the **ExchangeRate-API** to provide real-time currency conversion. Users can:

- Fetch exchange rates for a given base currency.
- Convert an amount from one currency to another.
- Handle API failures and invalid currency inputs gracefully.

## 🛠 Tech Stack

- **Backend:** Java, Spring Boot
- **HTTP Client:** RestTemplate
- **Build Tool:** Maven
- **Testing:** JUnit
- **IDE:** Eclipse
- **API Used:** [ExchangeRate-API](https://www.exchangerate-api.com/)


## ⚙️ Configuration

1. **Set Up ExchangeRate-API Key**
   - Register at [ExchangeRate-API](https://www.exchangerate-api.com/).
   - Replace `YOUR_API_KEY` in `application.properties`:
     ```properties
     exchange.rate.api.url=https://v6.exchangerate-api.com/v6/YOUR_API_KEY/latest/
     ```

## 🚀 Running the Application

### 1️⃣ Clone the Repository

```sh
git clone https://github.com/Ananya-S2580/CurrencyConversion-API-Integration.git 
cd CurrencyConversion-API-Integration
```

### 2️⃣ Build and Run the Application

```sh
mvn clean install
mvn spring-boot:run
```

The server starts at `http://localhost:8080`.

## 🔥 API Endpoints

### ✅ Fetch Exchange Rates

**Request:**

```
GET /api/rates?base=USD
```

**Response:**

```json
{
  "base_code": "USD",
  "conversion_rates": {
    "EUR": 0.94,
    "GBP": 0.81
  }
}
```

### ✅ Convert Currency

**Request:**

```
POST /api/convert
```

**Request Body:**

```json
{
  "from": "USD",
  "to": "EUR",
  "amount": 100
}
```

**Response:**

```json
{
  "from": "USD",
  "to": "EUR",
  "amount": 100,
  "convertedAmount": 94.0
}
```

## 🧪 Testing

Run unit tests using JUnit:

```sh
mvn test
```

## ❌ Error Handling

- **Invalid Currency Codes:** Returns `400 Bad Request`
- **API Unavailable:** Returns `500 Internal Server Error`



