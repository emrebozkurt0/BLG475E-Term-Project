# BLG475E Phase 1 - Software Quality and Testing Project

## Project Description

This repository is for the Phase 1 project of the BLG475E Software Quality and Testing class. The project focuses on evaluating Large Language Models (LLMs) for code generation, test generation, and test refactoring based on the HumanEval dataset using a semi-agentic approach.

## Summary

* 30 prompts were selected from the HumanEval Java dataset, 10 from each difficulty level (Easy, Moderate, Hard).
* For each prompt, source code and corresponding unit tests were generated using two different LLMs:
  * **Gemini** (Google's large language model)
  * **Codex** (OpenAI's code generation model)
* All generated code (60 files total) compiled successfully and was validated using JUnit 5.10.0 to assess correctness.
* Base tests were generated and executed, achieving a 100% pass rate across 588 base tests.
* **Test Smell Detection:** JNose was used to identify test smells (Unknown Test, Conditional Test Logic, Eager Test, and Lazy Test) in the LLM-generated tests.
* **Test Improvement:** LLM agents were queried to refactor the initial tests to remove smells while maintaining 100% branch coverage, resulting in clean, parameterized JUnit tests.
* **Manual Assessment:** Through manual inspection utilizing equivalence class partitioning and boundary value analysis, test gaps in the initial LLM tests were identified. Additional mutation-based tests were written systematically to enhance test coverage and handle unaddressed edge cases, following explicit inline comments patterns.

## Results

* **Generation:** Both Gemini and Codex performed excellently, generating 30/30 (100%) successfully compiling and correct algorithms, alongside corresponding test cases.
* **Test Design:** Initial LLM-generated tests often contained test smells (e.g., manual assertions instead of JUnit assertions, and conditional logic within tests) because they closely followed the raw dataset structure rather than JUnit best practices.
* **Refactoring:** Both LLMs successfully responded to refactoring prompts, producing clean, smell-free tests utilizing `@ParameterizedTest` and removing overlapping paths.
* **Test Coverage Assessment:** Initial tests only covered approximately 60.5% of equivalence classes on easy tests despite 100% branch coverage. Manual assessment revealed gaps (e.g., zero boundaries, negative values, empty inputs), which were successfully covered entirely after adding manual and robust mutations.

## Tools and Environment

* Java 11
* JUnit Jupiter (JUnit 5.10.0)
* Maven 3.x
* JaCoCo 0.8.10 (Code Coverage)
* Maven Surefire Plugin 3.1.2
* JNose (Test Smell Detection)