// Conectarse a la base de datos "productosDB"
db = db.getSiblingDB('productosDB');

// Crear una colección llamada "productos"
db.createCollection('productos');

// Insertar algunos productos de ejemplo
db.productos.insertMany([
  { nombre: "Producto 1", descripcion: "Descripción del producto 1", precio: 100 },
  { nombre: "Producto 2", descripcion: "Descripción del producto 2", precio: 200 },
  { nombre: "Producto 3", descripcion: "Descripción del producto 3", precio: 300 }
]);

print('Base de datos y colección productos creadas con éxito.');
