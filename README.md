# ollamaWithSpringAI

A small Spring Boot app that sends a prompt to a local [Ollama](https://ollama.com) model through Spring AI and returns the reply.

## Tech stack

- Java 21, Spring Boot 4.1
- Spring AI 2.0 (Ollama chat model)
- Ollama running `llama3.2` locally

## Prerequisites

1. Install Ollama and pull the model:
   ```bash
   ollama pull llama3.2
   ```
2. Make sure Ollama is running (default `http://localhost:11434`):
   ```bash
   ollama serve
   ```

## Useful Ollama commands

```bash
# Install Ollama (Linux)
curl -fsSL https://ollama.com/install.sh | sh

# List models downloaded locally
ollama list

# Run a model interactively (downloads it first if needed)
ollama run llama3.2

# Show models currently loaded in memory
ollama ps

# Remove a downloaded model
ollama rm llama3.2:latest
```

## Run

```bash
./mvnw spring-boot:run
```

The app starts on port **8055** (set in `src/main/resources/application.properties`).

## API

| Method | Path      | Query param | Description                                          |
|--------|-----------|-------------|------------------------------------------------------|
| GET    | `/prompt` | `message`   | Sends `message` to the model and returns its reply as plain text |
| GET    | `/ping`   | –           | Health check; returns `200 OK`                       |

## Sample request

```bash
curl "http://localhost:8055/prompt?message=what%20is%20your%20age"
```

Sample response (the exact text will vary):

```text
I don't have an age. I'm a computer program designed to understand and generate text, so I don't experience time or birthdays like humans do.
```

Health check:

```bash
curl "http://localhost:8055/ping"
# 200 OK
```

You can also open the URL directly in a browser:

```
http://localhost:8055/prompt?message=what%20is%20your%20age
```
