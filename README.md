# Shape Gallery with Java Collections (JCF)

This is a JavaFX application demonstrating **inheritance**, **polymorphism**, and the use of the **Java Collections Framework** (`List`, `Map`) to manage interactive GUI elements.

## Overview

Users can:
- Click a button to add a random shape (`Circle`, `Rectangle`, `Triangle`)
- View shape names in a `ListView`
- Filter shapes by type using a `ComboBox`
- Select a shape from the list to highlight it on the canvas

## Concepts Demonstrated

- **Inheritance**: All shapes inherit from the abstract `MyShape` class.
- **Polymorphism**: Shapes are drawn and highlighted using the same method call.
- **JCF**:
  - `List<MyShape>` is used to preserve drawing order
  - `Map<String, MyShape>` associates each shape with a unique name
- **JavaFX UI**: Layouts, buttons, canvas, event handling

## How to Run

1. Import this project into Eclipse or IntelliJ.
2. Set up your JavaFX SDK.
3. Make sure ypur project include all the required JavaFX libraries
  
4. Run `Main.java`.

## Project Structure

- `Main.java` – App entry point and GUI logic
- `MyShape.java` – Abstract base class
- `MyCircle.java` – Circle implementation
- `MyRectangle.java` – Rectangle implementation
- `MyTriangle.java` – Triangle implementation

## Features to Try

- Add shapes and select them from the list
- Try different filter options
- Explore how polymorphism simplifies shape handling

## Optional Extensions

- Add a "Clear All" button
- Allow shape deletion
- Animate shapes using `TranslateTransition`
- Store shape creation times with `Map<String, LocalDateTime>`

---

Happy coding!
