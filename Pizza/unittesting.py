import unittest
def add(x,y):
    return x+y


class TestAdd(unittest.TestCase):
    def test_add(self):
        result=add(2,3)
        self.assertEqual(5,result)

class TestAdd2(unittest.TestCase):
    def test_add(self):
        result=add(3,3)
        self.assertEqual(6,result)


if __name__ == '__main__':
    unittest.main()
    