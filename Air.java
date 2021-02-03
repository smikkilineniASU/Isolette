/*Shape:
const std::string m_Name;
double GetArea() = 0;
std::string GetName();

Circle:
Helper *mp_Helper;

Requirements:
•	GetName will return "Square" or "Circle" if it is a class Square or Circle.
•	GetArea will return a double:
•	Calculations for the area of a square is length * width
•	Calculations for the area of a circle is π (3.14) * r^2
Driver:
std::vector<Shape*> shapes;

shapes.push_back(new Square(...));
shapes.push_back(new Square(...));
shapes.push_back(new Circle(...));
shapes.push_back(new Square(...));
shapes.push_back(new Circle(...));
shapes.push_back(new Square(...));

for (std::vector<Shape*>::iterator itr = shapes.begin(); itr != shapes.end(); ++itr)
{
  std::cout << (*itr)->GetName() << ":\tArea = " << (*itr)->GetArea() << std::endl;
} 
*/

Public class Shape
{
	Public Shape(string name)
	{
		this.m_Name = name;
	}
	Final const std::string m_Name;

	double GetArea();

	string GetName()
	{
		return m_Name;
	}

}
		Circle extends Shape
		{
				Public ()
				{

				}
			double GetArea(double radius)
				{
					int x = ((radius)^2) * 3.14
					return x
				}

		}
