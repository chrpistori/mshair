-- Create table for clients
CREATE TABLE clients (
  id SERIAL PRIMARY KEY,
  full_name VARCHAR(100) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  email VARCHAR(100),
  birth_date DATE,
  created_at TIMESTAMPTZ DEFAULT NOW()
);

-- Create table for stylists
CREATE TABLE stylists (
  id SERIAL PRIMARY KEY,
  full_name VARCHAR(100) NOT NULL,
  ddd_phone VARCHAR(2) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  email VARCHAR(100),
  specialty VARCHAR(100),
  created_at TIMESTAMPTZ DEFAULT NOW()
);

-- Create table for appointments
CREATE TABLE appointments (
  id SERIAL PRIMARY KEY,
  client_id INT REFERENCES clients(id),
  stylist_id INT REFERENCES stylists(id),
  beauty_service_id INT REFERENCES beauty_services(id),
  appointment_date DATE NOT NULL,
  appointment_time TIME NOT NULL,
  duration_minutes INT NOT NULL,
  notes TEXT,
  created_at TIMESTAMPTZ DEFAULT NOW()
);

-- Create table for products
CREATE TABLE products (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  description TEXT,
  stock_quantity INT NOT NULL,
  created_at TIMESTAMPTZ DEFAULT NOW()
);

-- Create table for beauty_services_products (many-to-many relationship)
CREATE TABLE beauty_services_products (
  beauty_service_id INT REFERENCES beauty_services(id),
  product_id INT REFERENCES products(id),
  PRIMARY KEY (beauty_service_id, product_id)
);

-- Create table for preferences
CREATE TABLE preferences (
  id SERIAL PRIMARY KEY,
  client_id INT REFERENCES clients(id),
  stylist_id INT REFERENCES stylists(id),
  preferred_product_id INT REFERENCES products(id),
  notes TEXT,
  created_at TIMESTAMPTZ DEFAULT NOW()
);

-- Create table for payment records
CREATE TABLE payments (
  id SERIAL PRIMARY KEY,
  appointment_id INT REFERENCES appointments(id),
  amount DECIMAL(10, 2) NOT NULL,
  payment_date DATE NOT NULL,
  payment_method VARCHAR(100) NOT NULL,
  created_at TIMESTAMPTZ DEFAULT NOW()
);

-- Create table for professionals' schedules
CREATE TABLE schedules (
  id SERIAL PRIMARY KEY,
  stylist_id INT REFERENCES stylists(id),
  available_date DATE NOT NULL,
  available_start_time TIME NOT NULL,
  available_end_time TIME NOT NULL,
  created_at TIMESTAMPTZ DEFAULT NOW()
);

-- Create table for notes
CREATE TABLE notes (
  id SERIAL PRIMARY KEY,
  note_text TEXT NOT NULL,
  expected_date DATE,
  created_at TIMESTAMPTZ DEFAULT NOW()
);

-- Create table for entity_notes (many-to-many relationship)
CREATE TABLE entity_notes (
  id SERIAL PRIMARY KEY,
  entity_type VARCHAR(20) NOT NULL,
  entity_id INT NOT NULL,
  note_id INT REFERENCES notes(id)
);